package com.le.tomcat;

import com.le.standard.http.HttpServlet;
import com.le.tomcat.servlets.MethodNotAllowed;
import com.le.tomcat.servlets.NotFoundServlet;
import com.le.tomcat.servlets.NotLogin;

import java.util.HashMap;
import java.util.Map;

public class ErrorServlet {
    public static Map<Integer, HttpServlet> ErrorServletMap = new HashMap<>();

    static {
        ErrorServletMap.put(401,new NotLogin());
        ErrorServletMap.put(404,new NotFoundServlet());
        ErrorServletMap.put(405,new MethodNotAllowed());
    }

    public static HttpServlet get(int sc){
        return ErrorServletMap.get(sc);
    }
}
