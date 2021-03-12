package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login301")
public class login301Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求，响应编码，及响应数据类型
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        String u = req.getParameter("username");
        String p = req.getParameter("password");
        System.out.println(u+""+p);
        if("abc".equals(u)&&"123".equals(p)){
            //重定向：http状态码设置为301/302/307，响应头location
            resp.sendRedirect("home.html");
        }else if("abc".equals(u)){
            //转发
            req.getRequestDispatcher("home.html").forward(req,resp);
        }else{
            PrintWriter pw = resp.getWriter();
            pw.println("登录失败");
            pw.printf("用户名 %s 或密码错误!",u);
            pw.flush();
            pw.close();
        }

    }
}
