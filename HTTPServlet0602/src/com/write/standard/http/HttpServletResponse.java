package com.write.standard.http;

import com.write.standard.ServletResponse;

public interface HttpServletResponse extends ServletResponse {
    void addCookie(Cookie cookie);

    void sendError(int sc);

    void sendRedirect(String name,String value);

    void setStatus(int sc);
}
