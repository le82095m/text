package com.le.standard.http;

import com.le.standard.Servlet;
import com.le.standard.ServletException;
import com.le.standard.ServletRequest;
import com.le.standard.ServletResponse;
import com.le.tomcat.http.Response;

import java.io.IOException;

public abstract class HttpServlet implements Servlet {
    @Override
    public void init() throws ServletException {

    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException, ClassNotFoundException {
        if(req instanceof HttpServletRequest && resp instanceof  HttpServletResponse){
            HttpServletRequest httpReq = (HttpServletRequest)req;
            Response httpResp = (Response) resp;
            service(httpReq,httpResp);
        }else{
            throw new ServletException("不支持非 HTTP 协议");
        }
    }

    private void service(HttpServletRequest req, Response resp) throws ServletException, IOException, ClassNotFoundException {
        switch (resp.getStatus()){
            case 200:
                doGet(req,resp);
                break;
            case 401:
                resp.sendError(401).doGet(req,resp);
                break;
            case 404:
                resp.sendError(404).doGet(req,resp);
                break;
            case 405:
                resp.sendError(405).doGet(req,resp);
                break;
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException {
        resp.sendError(405);
    }

    @Override
    public void destroy() {

    }
}
