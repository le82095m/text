package v2;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RequestResponseTask implements Runnable{
    private static final String DOC_BASE="D:\\JavaDemo\\HTTPServletStude\\docBase";
    private final Socket socket;

    public RequestResponseTask(Socket socket) {
        this.socket = socket;
    }

    private static final Map<String,String> mimeTypeMap = new HashMap<>();
    static {
        mimeTypeMap.put("txt","text/plain");
        mimeTypeMap.put("html","text/html");
        mimeTypeMap.put("js","application/javascript");
        mimeTypeMap.put("jpg","image/jpeg");
    }

    @Override
    public void run() {
        try {
            System.out.println("一条TCP链接已连接");

            // 进行HTTP请求解析 -> 解析出路径

            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream,"UTF-8");
            scanner.next();//读取出来的是方法，暂时不用，所以没保存
            String path = scanner.next();
            System.out.println(path);

            if(path.equals("/")){
                path = "/index.html";
            }

            String filePath = DOC_BASE + path; //用户请求的静态对应的路径
            //1.判断该文件是否存在-file
            File resource = new File(filePath);
            if(resource.exists()){
                //读取文件内容，并写入respond

                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream,"UTF-8");
                PrintWriter printWriter = new PrintWriter(writer);

                String contentType = "text/plain";
                //找到路径对应的后缀(字符串处理)
                if(path.contains(".")){
                    int i = path.lastIndexOf(".");
                    String suffix = path.substring(i+1);
                    contentType = mimeTypeMap.getOrDefault(suffix,contentType);
                }
                //如果 contentType 是"text/..",
                if(contentType.startsWith("text/")){
                    contentType = contentType+"; charset=utf-8";
                }
                //这里把字符集统一设定成 utf-8

                printWriter.printf("HTTP/1.0 200 OK\r\n");
                printWriter.printf("Content-Type: %s\r\n",contentType);
                printWriter.printf("\r\n");
                printWriter.flush();

                //写入 response body(请求体)
                try(InputStream resourceInputStream = new FileInputStream(resource)){
                    byte[] buffer = new byte[1024];
                    while (true){
                        int len = resourceInputStream.read(buffer);
                        if(len == -1){
                            break;
                        }
                        outputStream.write(buffer,0,len);
                    }
                    outputStream.flush();
                }
            }else {
                //response 404
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream,"UTF-8");
                PrintWriter printWriter = new PrintWriter(writer);

                printWriter.printf("HTTP/1.0 404 NOT Found\r\n");
                printWriter.printf("Content-Type: text/html; charset=utf-8\r\n");
                printWriter.printf("\r\n");
                printWriter.printf("<h1>%s: 对应的资源不存在</h1>",path);
                printWriter.flush();
            }
        }catch (IOException e){
            //因为单次的请求响应周期错误，不应该影响其他请求响应周期
            e.printStackTrace(System.out);
        }finally {
            try {
                 socket.close();
                System.out.println("一条TCP链接已释放");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
