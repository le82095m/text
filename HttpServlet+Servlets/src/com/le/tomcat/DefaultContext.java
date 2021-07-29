package com.le.tomcat;

import com.le.standard.Servlet;

public class DefaultContext extends Context {

    public DefaultContext(ConfigReader reader) {
        super(reader, "/");
    }

    @Override
    public Servlet getServlet(String servletPath) {
        return ErrorServlet.get(404);
    }
}
