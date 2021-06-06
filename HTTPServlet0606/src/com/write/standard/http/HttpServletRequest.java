package com.write.standard.http;

import com.write.standard.ServletRequest;

public interface HttpServletRequest extends ServletRequest {
    Cookie[] getCookies();

    String getHeader(String name);

    String getMethod();

    String getRequestURI();

    String contextPath();

    String servletPath();

    HttpSession getSession();
}
