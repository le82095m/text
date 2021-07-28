package com.le.tomcat;

import com.le.standard.Servlet;
import com.le.standard.ServletException;

import java.io.IOException;
import java.util.*;

public class Context {
    private final ConfigReader reader;
    private final String name;
    public Config config;
    private final ClassLoader webappClassLoader = Context.class.getClassLoader();

    public Context(ConfigReader reader, String name) {
        this.reader = reader;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void readConfigFile() throws IOException {
        config = reader.read(name);
    }

    List<Class<?>> servletClassList = new ArrayList<>();
    public void loadServletClasses() throws ClassNotFoundException {
         Set<String> servletClassNames = new HashSet<>(config.servletToServletClassNameMap.values());
         for(String servletClassName : servletClassNames){
             Class<?> servletClass = webappClassLoader.loadClass(servletClassName);
             servletClassList.add(servletClass);
         }
    }

    List<Servlet> servletList = new ArrayList<>();
    public void instantiateServletObjects() throws IllegalAccessException, InstantiationException {
        for(Class<?> servletClass : servletClassList){
            Servlet servlet = (Servlet) servletClass.newInstance();//默认调用该类的无参构造方法
            servletList.add(servlet);
        }
    }

    public void initializeServletObjects() throws ServletException {
        for(Servlet servlet : servletList){
            servlet.init();
        }
    }

    public Servlet getServlet(String servletPath) {
//        String servletName = config.urlToServletNameMap.getOrDefault(servletPath,"");
        String servletName = config.urlToServletNameMap.get(servletPath);
//        String servletClassName = config.servletToServletClassNameMap.getOrDefault(servletName,"");
        String servletClassName = config.servletToServletClassNameMap.get(servletName);
        if(servletClassName == null){
            return null;
        }
        Servlet handleServlet = null;
        for(Servlet servlet : servletList){
            if(servletClassName.equals(servlet.getClass().getCanonicalName())){
                handleServlet = servlet;
                break;
            }
        }
        return handleServlet;
    }

    public void destroyServlets() {
        for(Servlet servlet : servletList){
            servlet.destroy();
        }
    }
}
