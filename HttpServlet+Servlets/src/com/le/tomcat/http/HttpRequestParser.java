package com.le.tomcat.http;

import com.le.standard.http.Cookie;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.*;

public class HttpRequestParser {
    public Request parse(InputStream inputStream) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(inputStream,"UTF-8");
        //解析请求头
            //获取请求方法
        String method = scanner.next().toUpperCase();
            //获取URL
        String path = scanner.next();
            //获取版本信息
        String version = scanner.nextLine();

            //进一步分割 URL 将其分为定位路径(requestURI)和get方法的数据(queryString)
        int j = path.indexOf('?');
        String requestURI = path;
        String queryString;

            //进一步解析 queryString，利用 Map 存储每个数据
        Map<String,String> parameters = new HashMap<>();
        if(j != -1) {
            requestURI = path.substring(0,j);
            queryString = path.substring(j+1);
            for(String kv : queryString.split("&")){
                String[] kvPart = kv.split("=");
                String key = URLDecoder.decode(kvPart[0].trim(),"UTF-8");
                String value = URLDecoder.decode(kvPart[1].trim(),"UTF-8");
                parameters.put(key,value);
            }
        }

            //进一步解析 requestURI,解析为 项目应用路径(contextPath) 和 调用servlet路径(servletPath)
        int i = requestURI.indexOf('/',1);
        String contextPath = "/";
        String servletPath = requestURI;
        if(i != -1) {
            contextPath = requestURI.substring(1, i);
            servletPath = requestURI.substring(i);
        }

        //解析请求头
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

            //解析请求头中 cookie 字段
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
