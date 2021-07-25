package com.le.webapps.dictionary;

import com.le.standard.ServletException;
import com.le.standard.http.HttpServlet;
import com.le.standard.http.HttpServletRequest;
import com.le.standard.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class TranslateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String english = req.getParameter("english");

        String chinese = translate(english);

        resp.serContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>翻译服务</h1>");
        writer.println("<p>"+english+"的意思是"+chinese+"</p>");
    }

    private String translate(String english){
        String chinese = english;
        return chinese;
    }
}
