package com.le.tomcat;

import com.le.standard.ServletException;
import com.le.tomcat.servlets.DefaultServlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ServletInitialize {
    private static int step = 5;
    private static final ConfigReader reader = new ConfigReader();
    private static final Map<String,Context> contextMap = new HashMap<>();
    private static final DefaultContext defaultContext = new DefaultContext(reader);
    private static final DefaultServlet defaultServlet = new DefaultServlet();



    public static Map<String,Context> scanContexts() {
        File webappsRoot = new File(HttpServer.WEBAPPS_BASE);
        File[] files = webappsRoot.listFiles();
        if(files == null){
            throw new RuntimeException();
        }

        for(File file : files){
            if(!file.isDirectory()){
                continue;
            }

            String contextName = file.getName();
            Context context = new Context(reader,contextName);
            contextMap.put(contextName,context);
        }
        step--;
        return contextMap;
    }


    public static void parseContextConf() throws IOException {
        for(String contextName : contextMap.keySet()){
            contextMap.get(contextName).readConfigFile();
        }
        step--;
    }


    public static void loadServletClasses() throws ClassNotFoundException {
        for(String contextName : contextMap.keySet()){
            contextMap.get(contextName).loadServletClasses();
        }
        step--;
    }


    public static void instantiateServletObjects() throws InstantiationException, IllegalAccessException {
        for(String contextName : contextMap.keySet()){
            contextMap.get(contextName).instantiateServletObjects();
        }
        step--;
    }


    public static void initializeServletObjects() throws InstantiationException, IllegalAccessException, ServletException {
        defaultServlet.init();
        for(String contextName : contextMap.keySet()){
            contextMap.get(contextName).initializeServletObjects();
        }
        step--;
        if(step == 0){
            System.out.println("初始化工作完成");
        }
    }

    public static DefaultContext getDefaultContext() {
        return defaultContext;
    }

    public static DefaultServlet getDefaultServlet() {
        return defaultServlet;
    }

    public static Map<String, Context> getContextMap() {
        return contextMap;
    }
}
