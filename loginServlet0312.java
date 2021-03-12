package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求，响应编码，及响应数据类型
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        String u = req.getParameter("username");
        String p = req.getParameter("password");
        System.out.println(u+""+p);


        PrintWriter pw = resp.getWriter();
        pw.println("登录成功");
        pw.printf("欢迎你  %s",u);
        pw.flush();
        pw.close();
    }
}
