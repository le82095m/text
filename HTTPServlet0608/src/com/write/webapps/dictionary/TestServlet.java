package com.write.webapps.dictionary;

import com.write.standard.ServletException;
import com.write.standard.ServletRequest;
import com.write.standard.ServletResponse;
import com.write.standard.http.HttpServlet;
import com.write.standard.http.HttpServletRequest;
import com.write.standard.http.HttpServletResponse;

import java.io.IOException;

public class TestServlet extends HttpServlet {
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我是 test 的 doGet 方法");
    }
}
