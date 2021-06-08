package com.write.standard.http;

public interface HttpSession {
    Object getAttribute(String name);

    void removeAttribute(String name);

    void setAttribute(String name,Object attribute);
}
