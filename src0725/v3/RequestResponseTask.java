package v3;

import java.io.*;
import java.net.Socket;
import java.net.URLDecoder;
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
            Scanner scanner = new Scanner(inputStream, "UTF-8");
            //读取请求行
            String method = scanner.next();//获取请求方法,暂时不用只读
//            System.out.println("method:"+method);
            String URL = scanner.next();//获取请求路径
            System.out.println("URL"+URL);
            String version = scanner.nextLine();//获取版本信息
//            System.out.println("version:"+version);

            Map<String,String> headers = new HashMap<>();
            //通过 Scanner ，读取请求头，暂时不用只读
            String headerLine;
            while (scanner.hasNextLine()){
                headerLine=scanner.nextLine();
                System.out.println(headerLine);
                if(headerLine.isEmpty()){
                    break;
                }
                String[] part = headerLine.split(":");
                String key = part[0].trim().toLowerCase();
                String value = part[1].trim();
                headers.put(key,value);
            }

            if (URL.equals("/")) {
                URL = "/index.html";
            }

            String[] strings = URL.split("\\?");
            String path = strings[0];

            String queryString = "";
            String[] queryStrings = null;
            if(strings.length > 1) {
                queryString = strings[1];
                queryStrings = queryString.split("&");
            }


            OutputStream outputStream = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
            PrintWriter printWriter = new PrintWriter(writer);

            switch (path) {
                case "/set-cookie":
                    printWriter.println("HTTP/1.0 307 Temporary Redirect");
                    //响应头
//                    printWriter.println(URLEncoder.encode("Set-cookie: username=张三","utf-8"));
                    printWriter.println("Set-cookie: username=abc");
                    printWriter.println("Location: profile");
                    //空行
                    printWriter.println("");
                    printWriter.flush();
                    break;
                case "/profile":
                    printWriter.println("HTTP/1.0 200 OK");
                    //响应头
                    printWriter.println("Content-Type: text/html;charset=utf-8");
                    //空行
                    printWriter.println("");

                    String cookie = headers.getOrDefault("cookie",null);
                    System.out.println("cookie:"+cookie);
                    String username = null;

                    for(String cookieKV : cookie.split(":")){
                        String key = cookieKV.split("=")[0];
                        String val = cookieKV.split("=")[1];
                        if(key.equals("username")){
                            username = val;
                        }
                    }
                    if (username == null) {
                        printWriter.println("<h1>请先进行登陆</h1>");
                    } else {
                        printWriter.println("<h1>当前用户是: " + username + "</h1>");
                    }
                    printWriter.flush();
                    break;
                case "/redirect-to":
                    printWriter.println("HTTP/1.0 307 Temporary Redirect");
                    //响应头
                    printWriter.println("Location: /index.html");
                    //空行
                    printWriter.println("");
                    printWriter.flush();
                    break;
                case "/goodbye.html":
                    printWriter.println("HTTP/1.0 200 OK");
                    //响应头
                    printWriter.println("Content-Type: text/html; charset=utf-8");
                    //空行
                    printWriter.println("");
                    for (String target : queryStrings) {
                        String name = URLDecoder.decode(target.split("=")[1], "UTF-8");
                        //URLDecoder.decode()对字符解编码
                        printWriter.println("<h1>再见" + name + "</h1>");
                        //URLEncoder.encode();对字符编码
                    }
                    printWriter.flush();
                    break;
                default:

                    String contentType = "text/plain";
                    //找到路径对应的后缀名
                    if (path.contains(".")) {
                        int i = path.lastIndexOf(".");
                        String suffix = path.substring(i + 1);
                        contentType = mimeTypeMap.getOrDefault(suffix, contentType);
                    }
                    if (contentType.startsWith("text/")) {
                        contentType = contentType + ";charset=utf-8";
                    }

                    String filePath = DOC_BASE + path;
                    //1 判断文件是否存在
                    File file = new File(filePath);
                    if (file.exists()) {
                        //读取文件内容写入 response body
                        //响应行
                        printWriter.println("HTTP/1.0 200 OK");
                        //响应头
                        printWriter.println("Content-Type:" + contentType + ";charset=utf-8");
                        //空行
                        printWriter.println("");
                        printWriter.flush();
                        //响应体
                        try (InputStream resourceInputStream = new FileInputStream(file)) {
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
                    break;
            }
        }catch(IOException e){
            e.printStackTrace(System.out);
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
