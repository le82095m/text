package v3;

import java.io.*;
import java.net.Socket;
import java.net.URLDecoder;
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
            scanner.nextLine();//读取出来HTTP版本信息，暂时不用

            String requestURI = path;
            String queryString = "";
            if(path.contains("?")){
                int i = path.indexOf("?");
                requestURI = path.substring(0,i);
                queryString = path.substring(i+1);
            }
            System.out.println(requestURI);

            Map<String,String> headers = new HashMap<>();
            //通过Scanner，读取请求头
            String headerLine;
            while (scanner.hasNextLine() && !(headerLine = scanner.nextLine()).isEmpty()){
                //通过 “:” 分割
                String[] part = headerLine.split(":");
                String name = part[0].trim().toLowerCase();//HTTP 的header-name是没有大小写之分的
                String value = part[1].trim();

                headers.put(name,value);
            }

            if(requestURI.equals("/")){
                requestURI = "/test.html";
            }

            if(requestURI.equals("/set-cookie")){
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream,"UTF-8");
                PrintWriter printWriter = new PrintWriter(writer);

                printWriter.printf("HTTP/1.0 307 Temporary Redirect\r\n");
                printWriter.printf("Set-Cookie: username=abc\r\n");
                printWriter.printf("Location: profile\r\n");
                printWriter.printf("\r\n");
                printWriter.flush();
            }else if(requestURI.equals("/profile")){
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream,"UTF-8");
                PrintWriter printWriter = new PrintWriter(writer);

                String username = null;
                //从 cookie 中获取 username，如何获取
                //Cookie信息要从请求头中获取

                String cookie = headers.getOrDefault("cookie","");
                System.out.println("Cookie: " + cookie);
                for (String cookieKV : cookie.split(";")){
                    if(cookieKV.isEmpty()){
                        continue;
                    }
                    String[] kv = cookieKV.split("=");
                    String cookieName = kv[0];
                    String cookieValue = kv[1];
                    if(cookieName.equals("username")){
                        username = cookieValue;
                    }
                }

                printWriter.printf("HTTP/1.0 200 OK\r\n");
                printWriter.printf("Content-Type: text/html; charset=utf-8\r\n");
                printWriter.printf("\r\n");
                if(username != null){
                    printWriter.printf("<h1>当前用户是: %s</h1>",username);
                }else{
                    printWriter.printf("<h1>请先进行登录</h1>");
                }
                printWriter.flush();
            }else if(requestURI.equals("/redirect-to")){
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream,"UTF-8");
                PrintWriter printWriter = new PrintWriter(writer);

                printWriter.printf("HTTP/1.0 307 Temporary Redirect\r\n");
                printWriter.printf("Location: /hello.jpg\r\n");
                printWriter.printf("\r\n");
                printWriter.flush();
            }else if(requestURI.equals("/goodbye.html")){
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream,"UTF-8");
                PrintWriter printWriter = new PrintWriter(writer);

                String target = "陌生人";
                for (String kv : queryString.split("&")){
                    if(kv.isEmpty()){
                        continue;
                    }
                    String[] part = kv.split("=");

                    String key = URLDecoder.decode(part[0],"UTF-8");
                    String value = URLDecoder.decode(part[1],"UTF-8");

                    if(key.equals("target")){
                        target = value;
                    }
                }

                printWriter.printf("HTTP/1.0 200 OK\r\n");
                printWriter.printf("Content-Type: text/html; charset=utf-8\r\n");
                printWriter.printf("\r\n");
                printWriter.printf("<h1>再见%s</h1>",target);
                printWriter.flush();
            }else {
                String filePath = DOC_BASE + requestURI; //用户请求的静态对应的路径
                //1.判断该文件是否存在-file
                File resource = new File(filePath);
                if (resource.exists()) {
                    //读取文件内容，并写入respond

                    OutputStream outputStream = socket.getOutputStream();
                    Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
                    PrintWriter printWriter = new PrintWriter(writer);

                    String contentType = "text/plain";
                    //找到路径对应的后缀(字符串处理)
                    if(requestURI.contains(".")) {
                        int i = requestURI.lastIndexOf(".");
                        String suffix = requestURI.substring(i + 1);
                        contentType = mimeTypeMap.getOrDefault(suffix, contentType);
                    }
                    //如果 contentType 是"text/..",
                    if(contentType.startsWith("text/")) {
                        contentType = contentType + "; charset=utf-8";
                    }
                    //这里把字符集统一设定成 utf-8

                    printWriter.printf("HTTP/1.0 200 OK\r\n");
                    printWriter.printf("Content-Type: %s\r\n", contentType);
                    printWriter.printf("\r\n");
                    printWriter.flush();

                    //写入 response body(请求体)
                    try (InputStream resourceInputStream = new FileInputStream(resource)) {
                        byte[] buffer = new byte[1024];
                        while (true) {
                            int len = resourceInputStream.read(buffer);
                            if (len == -1) {
                                break;
                            }
                            outputStream.write(buffer, 0, len);
                        }
                        outputStream.flush();
                    }
                } else {
                    //response 404
                    OutputStream outputStream = socket.getOutputStream();
                    Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
                    PrintWriter printWriter = new PrintWriter(writer);

                    printWriter.printf("HTTP/1.0 404 NOT Found\r\n");
                    printWriter.printf("Content-Type: text/html; charset=utf-8\r\n");
                    printWriter.printf("\r\n");
                    printWriter.printf("<h1>%s: 对应的资源不存在</h1>", requestURI);
                    printWriter.flush();
                }
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