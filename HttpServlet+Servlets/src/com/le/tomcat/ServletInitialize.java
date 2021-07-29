package com.le.tomcat;

import com.le.standard.ServletException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServletInitialize {
    private static int step = 5;
    private static final ConfigReader reader = new ConfigReader();
    private static final List<Context> contextList = new ArrayList<>();
    private static final DefaultContext defaultContext = new DefaultContext(reader);


    public static List<Context> scanContexts() {
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
            contextList.add(context);
        }
        step--;
        return contextList;
    }


    public static void parseContextConf() throws IOException {
        for(Context context : contextList){
            context.readConfigFile();
        }
        step--;
    }


    public static void loadServletClasses() throws ClassNotFoundException {
        for(Context context : contextList){
            context.loadServletClasses();
        }
        step--;
    }


    public static void instantiateServletObjects() throws InstantiationException, IllegalAccessException {
        for(Context context : contextList){
            context.instantiateServletObjects();
        }
        step--;
    }


    public static void initializeServletObjects() throws InstantiationException, IllegalAccessException, ServletException {
        HttpServer.defaultServlet.init();
        for(Context context : contextList){
            context.initializeServletObjects();
        }
        step--;
        if(step == 0){
            System.out.println("初始化工作完成");
        }
    }

    public static DefaultContext getDefaultContext() {
        return defaultContext;
    }
}
