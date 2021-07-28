package com.le.tomcat.http;

import com.le.standard.http.Cookie;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.*;

public class HttpRequestParser {
    //URL : http://127.0.0.1:8080/dictionary/translate
    public Request parse(InputStream inputStream) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(inputStream,"UTF-8");
        String method = scanner.next().toUpperCase();

        String path = scanner.next();

        String version = scanner.nextLine();

        int j = path.indexOf('?');
        String requestURI = path;

        Map<String,String> parameters = new HashMap<>();
        if(j != -1) {
            requestURI = path.substring(0,j);
            String queryString = path.substring(j+1);
            for(String kv : queryString.split("&")){
                String[] kvPart = kv.split("=");
                String key = URLDecoder.decode(kvPart[0].trim(),"UTF-8");
                String value = URLDecoder.decode(kvPart[1].trim(),"UTF-8");
                parameters.put(key,value);
            }
        }
        System.out.println("requestURI:"+requestURI);
        System.out.println("parameters:"+parameters);
        int i = requestURI.indexOf('/',1);
        String contextPath = "/";
        String servletPath = requestURI;
        if(i != -1) {
            contextPath = requestURI.substring(1, i);
            servletPath = requestURI.substring(i);
        }

        Map<String,String> headers = new HashMap<>();
        List<Cookie> cookieList = new ArrayList<>();
        String headerLine;
        while(scanner.hasNextLine()){
            headerLine = scanner.nextLine().trim();

            if(headerLine.isEmpty()){
                break;
            }

            String[] part = headerLine.split(":");
            String key = part[0].trim().toLowerCase();
            String value = part[1].trim();
            headers.put(key,value);

            if(key.equals("cookie")){
                String[] kvParts = value.split(";");
                for(String kvPart : kvParts) {
                    if(kvPart.trim().isEmpty()){
                        continue;
                    }
                    String cookieName = kvPart.split("=")[0].trim().toLowerCase();
                    String cookieValue = kvPart.split("=")[1].trim();
                    Cookie cookie = new Cookie(cookieName, cookieValue);
                    cookieList.add(cookie);
                }
            }
        }
        return new Request(method,requestURI,contextPath,servletPath,parameters,headers,cookieList);
    }
}
