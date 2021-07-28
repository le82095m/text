package com.le.tomcat.http;

import com.le.standard.http.Cookie;
import com.le.standard.http.HttpServletRequest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Request implements HttpServletRequest {
    private final String method;
    private final String requestURI;
    private final String contextPath;
    private final String servletPath;
    private final Map<String,String> parameter;
    private final Map<String,String> headers;
    private final List<Cookie> cookieList;
    public HttpSessionImpl session = null;

    public Request(String method, String requestURI, String contextPath, String servletPath, Map<String,String> parameter, Map<String, String> headers, List<Cookie> cookieList) throws IOException, ClassNotFoundException {
        this.method = method;
        this.requestURI = requestURI;
        this.contextPath = contextPath;
        this.servletPath = servletPath;
        this.parameter = parameter;
        this.headers = headers;
        this.cookieList = cookieList;
        for (Cookie cookie : cookieList) {
            if (cookie.getName().equals("session-id")) {
                String sessionID = cookie.getValue();
                session = new HttpSessionImpl(sessionID);
                break;
            }
        }
    }

    @Override
    public Cookie[] getCookies() {
        return cookieList.toArray(new Cookie[0]);
    }

    @Override
    public String getHeader(String name) {
        return headers.getOrDefault(name,null);
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public String getContextPath() {
        return contextPath;
    }

    @Override
    public String getServletPath() {
        return servletPath;
    }

    @Override
    public String getRequestURI() {
        return requestURI;
    }

    @Override
    public HttpSessionImpl getSession() throws IOException, ClassNotFoundException {
//        HttpSessionImpl httpSession = new HttpSessionImpl();
//        for(Cookie cookie : cookieList){
//            System.out.println("cookieName:"+cookie.getName());
//            System.out.println("cookieValue:"+cookie.getValue());
//            if(cookie.getName().equals("session-id")){
//                httpSession = new HttpSessionImpl(cookie.getValue());
//            }else{
//                httpSession = new HttpSessionImpl();
//            }
//        }
//        return httpSession;
        if(session != null) {
            return session;
        }else{
            return new HttpSessionImpl();
        }
    }

    @Override
    public String getParameter(String name) {
        return parameter.getOrDefault(name,null);
    }

    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\n' +
                "requestURI='" + requestURI + '\n' +
                "contextPath='" + contextPath + '\n' +
                "servletPath='" + servletPath + '\n' +
                "parameter=" + parameter + '\n' +
                "headers=" + headers + '\n' +
                "cookieList=" + cookieList + '\n' +
                "session=" + session +'\n'+
                '}';
    }
}
