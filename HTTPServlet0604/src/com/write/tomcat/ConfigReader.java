package com.write.tomcat;

import com.write.tomcat.http.HttpServer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ConfigReader {
    public Config read(String name){
        //定义两个存放Servlet的Map
        Map<String,String> servletNameToClassNameMap = new HashMap<>();
        LinkedHashMap<String,String> urlToServletNameMap = new LinkedHashMap<>();

        //web.conf 放哪里，必须符合规范，否则就会读不到
        String filename = String.format("%s/%s/WEB-INF/web.conf", HttpServer.WEBAPPS_BASE,name);

        String stage = "start";//"servlets"/"mappings"

        //进行文本文件的读取
        try(InputStream is = new FileInputStream(filename)){
            Scanner scanner = new Scanner(is,"UTF-8");
            while(scanner.hasNextLine()){
                String line = scanner.nextLine().trim();
//                System.out.println(line);
                if(line.isEmpty() || line.startsWith("#")){
                    //如果是空行或注释，跳过
                    continue;
                }

                switch (stage){
                    case "start":
                        if(line.equals("servlets:")){
                            stage = "servlets";
                        }
                        break;
                    case "servlets":
                        if(line.equals("servlet-mappings:")){
                            stage = "mappings";
                        }else{
                            //进行 ServletName => ServletClassName 的解析
                            String[] parts = line.split("=");
                            String servletName = parts[0].trim();
                            String servletClassName = parts[1].trim();
                            servletNameToClassNameMap.put(servletName,servletClassName);
                        }
                        break;
                    case "mappings":
                        //进行URL => ServletName 的解析
                        String[] parts = line.split("=");
                        String url = parts[0].trim();
                        String servletName = parts[1].trim();
                        urlToServletNameMap.put(url,servletName);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(servletNameToClassNameMap);
        System.out.println(urlToServletNameMap);

        return  new Config(servletNameToClassNameMap,urlToServletNameMap);
    }
}
