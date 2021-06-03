package com.write.webapps.dictionary;

import com.write.standard.Servlet;
import com.write.standard.ServletException;
import com.write.standard.ServletRequest;
import com.write.standard.ServletResponse;

import java.io.IOException;

public class TestServlet implements Servlet {
    public TestServlet() {
        System.out.println("我是 TestServlet 构造方法");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("我是 TestServlet inti方法");
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void destroy() {

    }
}
