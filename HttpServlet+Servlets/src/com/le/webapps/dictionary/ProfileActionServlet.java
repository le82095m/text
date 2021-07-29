package com.le.webapps.dictionary;

import com.le.standard.ServletException;
import com.le.standard.http.HttpServlet;
import com.le.standard.http.HttpServletRequest;
import com.le.standard.http.HttpServletResponse;
import com.le.standard.http.HttpSession;

import java.io.IOException;

public class ProfileActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        System.out.println("User:"+user);
        if(user == null){
            resp.sendRedirect("login.html");
        }else{
            resp.setContentType("text/plain");
            resp.getWriter().println(user.toString());
        }
    }
}
