package com.write.tomcat.http;

import com.write.standard.http.Cookie;
import com.write.standard.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Response implements HttpServletResponse {
    @Override
    public void addCookie(Cookie cookie) {

    }

    @Override
    public void sendError(int sc) {

    }

    @Override
    public void sendRedirect(String name, String value) {

    }

    @Override
    public void setStatus(int sc) {

    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return null;
    }

    @Override
    public void setContentType(String type) {

    }
}
