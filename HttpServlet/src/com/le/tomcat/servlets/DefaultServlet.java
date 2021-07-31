package com.le.tomcat.servlets;

import com.le.standard.ServletException;
import com.le.standard.http.HttpServlet;
import com.le.standard.http.HttpServletRequest;
import com.le.standard.http.HttpServletResponse;
import com.le.tomcat.ErrorServlet;
import com.le.tomcat.HttpServer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DefaultServlet extends HttpServlet {
    private final String defaultContentType = "text/plain";
    private final String welcomeFile = "/index.html";
    private final Map<String, String> mime = new HashMap<>();

    @Override
    public void init() throws ServletException {
        mime.put("htm","text/html");
        mime.put("html","text/html");
        mime.put("jpg","image/jpeg");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException {
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();

        if(servletPath.equals("/")){
            servletPath = welcomeFile;
        }

        String filename = HttpServer.WEBAPPS_BASE+"\\"+contextPath+"\\"+servletPath;
        File file = new File(filename);
        if(!file.exists()){
            ErrorServlet.get(404).service(req,resp);
            return;
        }

        String contentType = getContentType(servletPath);
        resp.setContentType(contentType);

        OutputStream outputStream = resp.getOutputStream();
        try(InputStream inputStream = new FileInputStream(file)) {
            byte[] buffer = new byte[1024];
            int len = -1;
            while((len = inputStream.read(buffer)) != -1){
                outputStream.write(buffer,0,len);
            }
            outputStream.flush();
        }
    }

    private String getContentType(String servletPath) {
        String contentType = defaultContentType;
        int i = servletPath.lastIndexOf('.');
        if(i != -1){
            String extension = servletPath.substring(i+1);
            contentType = mime.getOrDefault(extension,defaultContentType);
        }
        return contentType;
    }
}
