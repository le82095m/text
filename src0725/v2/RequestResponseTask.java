package v2;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RequestResponseTask implements Runnable{
    private static final String DOC_BASE = "D:\\JavaDemo\\myTomcat\\docBase";
    private final Socket socket;
    private static final Map<String,String> mimeTypeMap = new HashMap<>();
    static {
        mimeTypeMap.put("txt","text/plain");
        mimeTypeMap.put("html","text/html");
    }

    public RequestResponseTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //解析HTTP请求 -> 找到URL
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream,"UTF-8");
            scanner.next();
            String path = scanner.next();
            System.out.println(path);

            if(path.equals("/")){
                path = "/index.html";
            }

            OutputStream outputStream = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
            PrintWriter printWriter = new PrintWriter(writer);

            String contentType = "text/plain";
            //找到路径对应的后缀名
            if(path.contains(".")){
                int i = path.lastIndexOf(".");
                String suffix = path.substring(i+1);
                contentType = mimeTypeMap.getOrDefault(suffix,contentType);
            }
            if(contentType.startsWith("text/")){
                contentType = contentType+";charset=utf-8";
            }

            String filePath = DOC_BASE+path;
            //1 判断文件是否存在
            File file = new File(filePath);
            if(file.exists()){
                //读取文件内容写入 response body
                //响应行
                printWriter.println("HTTP/1.0 200 OK");
                //响应头
                printWriter.println("Content-Type:"+contentType+";charset=utf-8");
                //空行
                printWriter.println("");
                printWriter.flush();
                //响应体
                try (InputStream resourceInputStream = new FileInputStream(file)){
                    byte[] buffer = new byte[1024];
                    while(true){
                        int len = resourceInputStream.read(buffer);
                        if(len == -1){
                            break;
                        }
                        outputStream.write(buffer,0,len);
                    }
                    outputStream.flush();
                }
            }else{
                //返回404
                //响应行
                printWriter.println("HTTP/1.0 404 Not Found");
                //响应头
                printWriter.println("Content-Type:text/html;charset=utf-8");

                printWriter.println("");
                //响应体
                printWriter.println("<h1>资源未找到</h1>");
                printWriter.flush();
            }
            socket.close();
        }catch (IOException e){
            e.printStackTrace(System.out);
        }
    }
}
