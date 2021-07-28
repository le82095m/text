package com.le.tomcat;

import com.le.standard.Servlet;
import com.le.standard.ServletException;
import com.le.standard.http.Cookie;
import com.le.tomcat.http.HttpRequestParser;
import com.le.tomcat.http.Request;
import com.le.tomcat.http.Response;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class RequestResponseTask implements Runnable {
    private static HttpRequestParser parser;
    private final Socket socket;
    public RequestResponseTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //1. 解析并得到请求对象
        try {
            InputStream inputStream = socket.getInputStream();
            if (parser == null) {
                parser = new HttpRequestParser();
            }
            Request request = parser.parse(inputStream);
//            System.out.println(request);

//            OutputStream os = socket.getOutputStream();
//            Writer writer = new OutputStreamWriter(os,"UTF-8");
//            PrintWriter printWriter = new PrintWriter(writer);
//
//            printWriter.println("HTTP/1.0 200 OK");
//            printWriter.println();
//            printWriter.flush();
            //2. 实例化一个响应对象
            Response response = new Response();
            //3. 根据 request.getContextPath()找到哪个 Context 进行处理
            Context handleContext = ServletInitialize.getDefaultContext();
            String contextPath = request.getContextPath();
            System.out.println("contextPath:"+contextPath);
            for(Context context : HttpServer.contextList){
                if(context.getName().equals(contextPath)){
                    handleContext = context;
                    break;
                }
            }
            //4. 根据 request.getServletPath()找到 Context 中的哪个 HttpServlet 进行处理
            System.out.println("handleContext:"+handleContext.getName());
            Servlet servlet = handleContext.getServlet(request.getServletPath());
            if(servlet == null){
                servlet = HttpServer.defaultServlet;
            }
            //5. 调用 Servlet.service(request,response), 交给业务处理
            servlet.service(request,response);
            //6. 根据 response 对象中的数据，发送 HTTP 响应
            System.out.println(response);
            sendResponse(socket.getOutputStream(),request,response);
        } catch (IOException | ClassNotFoundException | ServletException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendResponse(OutputStream outputStream, Request request,Response response) throws IOException, ClassNotFoundException {
        //保存session
        //1.种cookie
        //2.保存成文件
        if(request.getSession() != null){
            Cookie cookie = new Cookie("session-id",request.getSession().sessionID);
            response.addCookie(cookie);
            request.getSession().saveSessionData();
        }

        Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        PrintWriter printWriter = new PrintWriter(writer);
        for(Cookie cookie : response.cookieList){
//            System.out.println("cookieName:"+cookie.getName());
//            System.out.println("cookieValue:"+cookie.getValue());
            System.out.println();
            response.setHeader("Set-Cookie",cookie.getName()+"="+cookie.getValue());
        }

        printWriter.println("HTTP/1.0 "+response.status);
        for(String name : response.headers.keySet()){
            String value = response.headers.get(name);
            printWriter.println(name+": "+value);
        }
        printWriter.println();

        response.bodyOutputStream.flush();
        response.bodyPrintWriter.flush();
        printWriter.flush();


        byte[] bytes = response.bodyOutputStream.toByteArray();
        outputStream.write(bytes);
        outputStream.flush();
    }
}
