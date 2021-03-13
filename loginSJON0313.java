package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginJSON")
public class loginSJON extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求，响应编码，及响应数据类型
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        String u = req.getParameter("username");
        String p = req.getParameter("password");
//        System.out.println(u+""+p);


        PrintWriter pw = resp.getWriter();
        if("abc".equals(u) && "123".equals(p)) {
            pw.println("{\"success\" :true}");
        }else {
            pw.println("{\"success\" :false}");
        }
        pw.flush();
        pw.close();
    }
}
