package com.le.tomcat.servlets;

import com.le.standard.ServletException;
import com.le.standard.http.HttpServlet;
import com.le.standard.http.HttpServletRequest;
import com.le.standard.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class NotLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException {
        resp.setStatus(401);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>用户需要登录</h1>");
        resp.sendRedirect("profile-action");
    }
}
