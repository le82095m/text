package com.le.tomcat.http;

import com.le.standard.http.Cookie;
import com.le.standard.http.HttpServletResponse;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Response implements HttpServletResponse {
    public int status = 200;
    public final List<Cookie> cookieList;
    public final Map<String,String> headers;
    public final ByteArrayOutputStream bodyOutputStream;
    public final PrintWriter bodyPrintWriter;

    public Response() throws IOException {
        this.cookieList = new ArrayList<>();
        this.headers = new HashMap<>();
        this.bodyOutputStream = new ByteArrayOutputStream(1024);
        Writer writer = new OutputStreamWriter(bodyOutputStream,"UTF-8");
        this.bodyPrintWriter  = new PrintWriter(writer);
    }

    @Override
    public void addCookie(Cookie cookie) {
        cookieList.add(cookie);
    }

    @Override
    public void sendError(int sc) {
        //TODO
    }

    @Override
    public void sendRedirect(String location) {
        setStatus(307);
        setHeader("Location",location);
    }

    @Override
    public void setHeader(String name, String value) {
        headers.put(name,value);
    }

    @Override
    public void setStatus(int sc) {
        this.status = sc;
    }

    // 写入响应体(字节)
    @Override
    public OutputStream getOutputStream() throws IOException {
        return bodyOutputStream;
    }

    // 写入响应体(字符)
    @Override
    public PrintWriter getWriter() throws IOException {
        return bodyPrintWriter;
    }

    @Override
    public void setContentType(String type) {
        if(type.startsWith("text/")){
            type = type+"; charset=utf-8";
        }
        setHeader("Content-Type",type);
    }

    @Override
    public String toString() {
        try {
            bodyPrintWriter.flush();
            bodyOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return "Response{" +
                "status=" + status +
                ", headers=" + headers +
                "}";
    }
}
