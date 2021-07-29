package com.le.tomcat.http;

import com.le.standard.http.Cookie;
import com.le.standard.http.HttpServlet;
import com.le.standard.http.HttpServletResponse;
import com.le.tomcat.ErrorServlet;
import com.le.tomcat.servlets.MethodNotAllowed;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Response implements HttpServletResponse {
    public MethodNotAllowed methodNotAllowed = new MethodNotAllowed();
    private int status = 200;
    private final List<Cookie> cookieList;
    private final Map<String,String> headers;
    private final ByteArrayOutputStream bodyOutputStream;
    private final PrintWriter bodyPrintWriter;

    public Response() throws IOException {
        this.cookieList = new ArrayList<>();
        this.headers = new HashMap<>();
        this.bodyOutputStream = new ByteArrayOutputStream(1024);
        Writer writer = new OutputStreamWriter(bodyOutputStream, StandardCharsets.UTF_8);
        this.bodyPrintWriter  = new PrintWriter(writer);
    }

    @Override
    public void addCookie(Cookie cookie) {
        cookieList.add(cookie);
    }

    @Override
    public HttpServlet sendError(int sc) {
        return ErrorServlet.get(sc);
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

    public int getStatus() {
        return status;
    }

    public List<Cookie> getCookieList() {
        return cookieList;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public ByteArrayOutputStream getBodyOutputStream() {
        return bodyOutputStream;
    }

    public PrintWriter getBodyPrintWriter() {
        return bodyPrintWriter;
    }
}
