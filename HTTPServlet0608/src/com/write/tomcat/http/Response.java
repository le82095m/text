package com.write.tomcat.http;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import com.write.standard.ServletException;
import com.write.standard.http.Cookie;
import com.write.standard.http.HttpServletResponse;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Response implements HttpServletResponse {
    public int status = 200;
    public final List<Cookie> cookieList;
    public final Map<String,String> headers;
    public final ByteOutputStream bodyOutputStream;
    public final PrintWriter bodyPrintWriter;

    @Override
    public String toString() {
        bodyPrintWriter.flush();
        try {
            bodyOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return String.format("Response{%d %s %s}",status,headers,bodyOutputStream.toString());
    }

    public Response() throws UnsupportedEncodingException {
        this.headers = new HashMap<>();
        this.cookieList = new ArrayList<>();
        bodyOutputStream = new ByteOutputStream(1024);
        Writer writer = new OutputStreamWriter(bodyOutputStream,"UTF-8");
        bodyPrintWriter = new PrintWriter(writer);
    }

    @Override
    public void addCookie(Cookie cookie) {
        cookieList.add(cookie);
    }

    @Override
    public void sendError(int sc) {
//        TODO
    }

    @Override
    public void sendRedirect(String location) {
        setStatus(307);
        setHeader("location",location);
    }

    public void setHeader(String name, String value) {
        headers.put(name,value);
    }

    @Override
    public void setStatus(int sc) {
        this.status = sc;
    }

    //写入响应体(byte)
    @Override
    public OutputStream getOutputStream() throws ServletException {
        return bodyOutputStream;
    }

    //写入响应体(text)
    @Override
    public PrintWriter getWriter() throws IOException {
        return bodyPrintWriter;
    }

    @Override
    public void setContentType(String type) {
        if(type.startsWith("text/")){
            type = type+";charset=utf-8";
        }
        setHeader("Content-type",type);
    }
}
