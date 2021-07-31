package com.le.standard.http;

import com.le.standard.ServletResponse;

public interface HttpServletResponse extends ServletResponse {
    void addCookie(Cookie cookie);

    HttpServlet sendError(int sc);

    void sendRedirect(String location);

    void setHeader(String name,String value);

    void setStatus(int sc);
}
