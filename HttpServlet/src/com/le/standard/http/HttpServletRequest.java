package com.le.standard.http;

import com.le.standard.ServletRequest;
import com.le.tomcat.http.HttpSessionImpl;

import java.io.IOException;
import java.util.Map;

public interface HttpServletRequest extends ServletRequest {
    Map<String,Cookie> getCookies();

    String getHeader(String name);

    String getMethod();

    String getContextPath();

    String getServletPath();

    String getRequestURI();

    HttpSessionImpl getSession() throws IOException, ClassNotFoundException;
}
