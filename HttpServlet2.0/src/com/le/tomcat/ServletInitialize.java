package com.le.tomcat;

import com.le.standard.ServletException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServletInitialize {
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
            System.out.println(context.getName());
            contextList.add(context);
        }
        System.out.println("第一步: 扫描所有 context");
        return contextList;
    }


    public static void parseContextConf() throws IOException {
        for(Context context : contextList){
            context.readConfigFile();
        }
        System.out.println("第二步: 解析每个 Context 下的配置文件");
    }


    public static void loadServletClasses() throws ClassNotFoundException {
        for(Context context : contextList){
            context.loadServletClasses();
        }
        System.out.println("第三步: 加载每个 Context 下的Servlet类");
    }


    public static void instantiateServletObjects() throws InstantiationException, IllegalAccessException {
        for(Context context : contextList){
            context.instantiateServletObjects();
        }
        System.out.println("第四步: 实例化每个 Context 下的Servlet对象");
    }


    public static void initializeServletObjects() throws InstantiationException, IllegalAccessException, ServletException {
        HttpServer.defaultServlet.init();
        HttpServer.notFoundServlet.init();
        for(Context context : contextList){
            context.initializeServletObjects();
        }
        System.out.println("第五步: 对每个 Context 下的Servlet执行初始化");
    }

    public static DefaultContext getDefaultContext() {
        return defaultContext;
    }
}
