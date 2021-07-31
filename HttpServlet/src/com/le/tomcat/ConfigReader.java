package com.le.tomcat;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ConfigReader {
    private final Map<String,String> servletToServletClassNameMap = new HashMap<>();
    private final LinkedHashMap<String,String> urlToServletNameMap = new LinkedHashMap<>();

    public Config read(String name) throws IOException {
        //进行 web.conf 文件的读取+解析
        //使用状态机(start——servlet——mappings三个状态)
        String stage = "start";
        String filename = HttpServer.WEBAPPS_BASE+"/"+name+"/"+"WEB-INF/web.conf";
        //读取webapps下的WRB-INF文件
        try(InputStream is = new FileInputStream(filename)){
            Scanner scanner = new Scanner(is,"UTF-8");
            while(scanner.hasNextLine()){
                String line = scanner.nextLine().trim();
                if(line.isEmpty() || line.startsWith("#")){
                    continue;
                }
                switch (stage){
                    case "start":
                        if(line.equals("servlets:")){
                            stage = "servlet";
                        }
                        break;
                        case "servlet":
                            if(line.equals("servlet-mappings:")){
                                stage = "mappings";
                            }else{
                                String[] parts = line.split("=");
                                String servletName = parts[0].trim();
                                String servletClassName = parts[1].trim();
                                servletToServletClassNameMap.put(servletName,servletClassName);
                            }
                            break;
                        case "mappings":
                            String[] parts = line.split("=");
                            String url = parts[0].trim();
                            String servletName = parts[1].trim();
                            urlToServletNameMap.put(url,servletName);
                            break;
                }
            }
        }
        return new Config(servletToServletClassNameMap,urlToServletNameMap);
    }
}
