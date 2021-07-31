package com.le.tomcat.http;

import com.le.standard.http.Cookie;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class HttpResponseSend {
    public void send(OutputStream outputStream, Request request, Response response) throws IOException, ClassNotFoundException {
        //保存session
        if(request.getSession() != null){
            Cookie cookie = new Cookie("session-id",request.getSession().getSessionID());
            response.addCookie(cookie);//种入cookie中
            request.getSession().saveSessionData();//保存到本地成文件
        }

        //向响应头中添加cookie
        Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        PrintWriter printWriter = new PrintWriter(writer);
        for(String cookieName : response.getCookies().keySet()){
            System.out.println();
            response.setHeader("Set-Cookie",cookieName+"="+response.getCookies().get(cookieName).getValue());
        }

        //写回响应行
        printWriter.println("HTTP/1.0 "+response.getStatus());
        //写回响应头
        Map<String,String> headers = response.getHeaders();
        for(String name : headers.keySet()){
            String value = headers.get(name);
            printWriter.println(name+": "+value);
        }
        //写空行
        printWriter.println();

        //未涉及响应体

        response.getBodyOutputStream().flush();
        response.getWriter().flush();
        printWriter.flush();


        byte[] bytes = response.getBodyOutputStream().toByteArray();
        outputStream.write(bytes);
        outputStream.flush();
    }
}
