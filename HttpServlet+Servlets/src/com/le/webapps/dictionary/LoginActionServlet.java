package com.le.webapps.dictionary;

import com.le.standard.ServletException;
import com.le.standard.http.Cookie;
import com.le.standard.http.HttpServlet;
import com.le.standard.http.HttpServletRequest;
import com.le.standard.http.HttpServletResponse;
import com.le.tomcat.http.HttpSessionImpl;

import java.io.IOException;

public class LoginActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username.equals("abc") && password.equals("123")){
            User user = new User(username,password);
            HttpSessionImpl session = req.getSession();
            session.setAttribute("user",user);
            resp.sendRedirect("profile-action");
            resp.addCookie(new Cookie("session-id",session.getSessionID()));
        }else{
            resp.sendRedirect("login.html");
        }
    }
}
