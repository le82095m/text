package com.le.standard.http;

import com.le.standard.ServletRequest;

public interface HttpServletRequest extends ServletRequest {
    Cookie[] getCookies();

    String getHeader(String name);

    String getMethod();

    String getContextPath();

    String getServletPath();

    String getRequestURI();

    HttpSession getSession();
}
