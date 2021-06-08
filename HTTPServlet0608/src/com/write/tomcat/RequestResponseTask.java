package com.write.tomcat;

import com.write.standard.Servlet;
import com.write.standard.http.Cookie;
import com.write.tomcat.http.HttpRequestParser;
import com.write.tomcat.http.Request;
import com.write.tomcat.http.Response;

import java.io.*;
import java.net.Socket;
import java.util.Map;

public class RequestResponseTask implements Runnable {
    private static final HttpRequestParser parser = new HttpRequestParser();

    private final  Socket socket;

    public RequestResponseTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //1. 解析并得到请求对象
            Request req = parser.parse(socket.getInputStream());
            System.out.println(req);

//            OutputStream os = socket.getOutputStream();
//            Writer writer = new OutputStreamWriter(os,"UTF-8");
//            PrintWriter printWriter = new PrintWriter(writer);
//
//            printWriter.printf("HTTP/1.0 200 ok\r\n");
//            printWriter.printf("\r\n");
//            printWriter.flush();
            //2. 实例化好一个响应对象
            Response resp = new Response();
            //3. 根据 request.getContextPath() 找到哪个 Context 进行处理
            Context handleContext = HttpServer.defaultContext;
            for(Context context : HttpServer.contextsList){
                if(context.getName().equals(req.getContextPath())){
                    handleContext = context;
                    break;
                }
            }
            //4. 根据 request.getServletPath() 找到 Context 中的哪个 HttpServlet 进行处理
            Servlet servlet = handleContext.get(req.getServletPath());
            if(servlet == null){
                servlet = HttpServer.defaultServlet;
            }
            //5. 调用 servlet.service(request,response),交给业务处理
            servlet.service(req,resp);
            System.out.println(resp);
            //6. 根据 response 对象中的数据，发送 HTTP 请求
            sendResponse(socket.getOutputStream(),req,resp);

            socket.close();
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
//        try {
//            socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private void sendResponse(OutputStream outputStream,Request req, Response resp) throws IOException, ClassNotFoundException {
        //保存session
        //1. 种cookie
        //2. 保存成文件
        if(req.session != null){
            Cookie cookie = new Cookie("session-id",req.session.sessionID);
            resp.addCookie(cookie);
            req.session.saveSessionData();
        }

        Writer writer = new OutputStreamWriter(outputStream,"UTF-8");
        PrintWriter printWriter = new PrintWriter(writer);
        for(Cookie cookie : resp.cookieList){
            resp.setHeader("Set-Cookie",String.format("%s=%s",cookie.getName(),cookie.getValue()));
        }
        //保存cookie


        printWriter.printf("HTTP/1.0 %d\r\n",resp.status);
        for(Map.Entry<String,String> entry : resp.headers.entrySet()){
            String name = entry.getKey();
            String value = entry.getValue();

            printWriter.printf("%s:%s\r\n",name,value);
        }
        printWriter.printf("\r\n");
        resp.bodyPrintWriter.flush();
        resp.bodyOutputStream.flush();
        printWriter.flush();

        byte[] bytes = resp.bodyOutputStream.toByteArray();
        outputStream.write(bytes);
        outputStream.flush();
    }
}
 