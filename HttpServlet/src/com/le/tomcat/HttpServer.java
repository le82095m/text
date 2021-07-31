package com.le.tomcat;

import com.le.standard.ServletException;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Map;

public class HttpServer {
    public static final String WEBAPPS_BASE = "D:\\JavaDemo\\HttpServlet2.0\\webapps";


    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, ServletException {
        ServerSocket serverSocket = new ServerSocket(8080);

        //找到所有的本地Servlet对象，进行初始化
        initServlet();

        //创建线程池，每次请求分配一个线程处理
        PoolStart pool = new PoolStart();
        pool.processing(serverSocket);

        //找到所有的 Servlet 对象，销毁
        destroyServer();
    }


    private static void destroyServer() {
        Map<String,Context> contextMap = ServletInitialize.getContextMap();
        ServletInitialize.getDefaultServlet().destroy();
        for(String contextName : contextMap.keySet()){
            contextMap.get(contextName).destroyServlets();
        }
    }

    private static void initServlet() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, ServletException {
        //扫描出所有的 context
        ServletInitialize.scanContexts();
        //读取并解析各自的 Web 配置文件
        ServletInitialize.parseContextConf();
        //加载需要的 ServletClass 表现为 Class<?> 对象
        ServletInitialize.loadServletClasses();
        //实例化需要的 Servlet对象
        ServletInitialize.instantiateServletObjects();
        //执行 Servlet 的初始化工作
        ServletInitialize.initializeServletObjects();
    }

}
