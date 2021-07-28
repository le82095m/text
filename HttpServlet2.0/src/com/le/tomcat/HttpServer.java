package com.le.tomcat;

import com.le.standard.ServletException;
import com.le.tomcat.servlets.DefaultServlet;
import com.le.tomcat.servlets.NotFoundServlet;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;

public class HttpServer {
    public static final String WEBAPPS_BASE = "D:\\JavaDemo\\HttpServlet2.0\\webapps";
    public static DefaultServlet defaultServlet = new DefaultServlet();
    public static NotFoundServlet notFoundServlet = new NotFoundServlet();
    public static List<Context> contextList;

    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, ServletException {
        ServerSocket serverSocket = new ServerSocket(8080);

        initServlet();//找到所有的本地Servlet对象，进行初始化

        PoolStart pool = new PoolStart();
        pool.handlingRequest(serverSocket);//创建线程池，每次请求分配一个线程处理

        destroyServer();//找到所有的 Servlet 对象，销毁
    }

    private static void destroyServer() {
        defaultServlet.destroy();
        notFoundServlet.destroy();
        for(Context context : contextList){
            context.destroyServlets();
        }
    }

    private static void initServlet() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, ServletException {
        //扫描出所有的 context
        contextList = ServletInitialize.scanContexts();
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
