package com.le.tomcat;

import com.le.standard.Servlet;
import com.le.standard.ServletException;

import java.io.IOException;
import java.util.*;

public class Context {
    private final ConfigReader reader;
    private final String name;
    private Config config;
    private final ClassLoader webappClassLoader = Context.class.getClassLoader();

    public Context(ConfigReader reader, String name) {
        this.reader = reader;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Config getConfig() {
        return config;
    }

    public void readConfigFile() throws IOException {
        config = reader.read(name);
    }

    Map<String,Class<?>> servletClassMap = new HashMap<>();
    public void loadServletClasses() throws ClassNotFoundException {
         Set<String> servletClassNames = new HashSet<>(config.getServletToServletClassNameMap().values());
         for(String servletClassName : servletClassNames){
             Class<?> servletClass = webappClassLoader.loadClass(servletClassName);
             servletClassMap.put(servletClassName,servletClass);
         }
    }

    Map<String,Servlet> servletMap = new HashMap<>();
    public void instantiateServletObjects() throws IllegalAccessException, InstantiationException {
        for(String servletClassName : servletClassMap.keySet()){
            Servlet servlet = (Servlet) servletClassMap.get(servletClassName).newInstance();//默认调用该类的无参构造方法
            servletMap.put(servletClassName,servlet);
        }
    }

    public void initializeServletObjects() throws ServletException {
        for(String servletName : servletMap.keySet()){
            servletMap.get(servletName).init();
        }
    }

    public Servlet getServlet(String servletPath) {
        String servletName = config.getUrlToServletNameMap().get(servletPath);
        String servletClassName = config.getServletToServletClassNameMap().get(servletName);
        if(servletClassName == null){
            return null;
        }
        Servlet handleServlet = null;
        for(String ServletName : servletMap.keySet()){
            Servlet servlet = servletMap.get(ServletName);
            if(servletClassName.equals(servlet.getClass().getCanonicalName())){
                handleServlet = servlet;
                break;
            }
        }
        return handleServlet;
    }

    public void destroyServlets() {
        for(String servletName : servletMap.keySet()){
            servletMap.get(servletName).destroy();
        }
    }
}
