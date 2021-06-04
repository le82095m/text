package com.write.tomcat.http;

import com.write.standard.ServletException;
import com.write.tomcat.ConfigReader;
import com.write.tomcat.Context;
import com.write.tomcat.RequestResponseTask;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException, ServletException {

        //1. 找到所有的 Servlet 对象，进行初始化
        initServer();

        //2. 处理服务器逻辑
        startServer();

        //3. 找到所有的 Servlet 对象，进行销毁
        destroyServer();
    }

    private static void startServer() throws IOException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            //每次只处理一个Servlet
            Socket socket = serverSocket.accept();
            Runnable task = new RequestResponseTask(socket);
            threadPool.execute(task);
        }
    }


    private static void initServer() throws ClassNotFoundException, IllegalAccessException, InstantiationException, ServletException {
        scanContexts();
        //1. 扫描所有 Context (执行目录扫描)
        parseContextConf();
        //2. 针对所有 Context，需要知道有哪些 Servlet 类
        loadServletClasses();
        //3.进行类加载 => 利用反射进行类加载 class文件
        instantiateServletObjects();
        //4.进行实例化的过程 => 利用反射进行实例化
        initializeServletObjects();
        //5.调用 servlet.init() 进行初始化工作
    }

    private static void destroyServer() {
        for (Context context : contextsList) {
            context.destroyServlets();
        }
    }

    public static final String WEBAPPS_BASE = "D:\\JavaDemo\\HTTPServlet\\webapps";
    private static final List<Context> contextsList = new ArrayList<>();

    private static final ConfigReader reader = new ConfigReader();

    //扫描所有 Context (执行目录扫描)
    private static void scanContexts() {
        System.out.println("第一步目录扫描");
        File webappsRoot = new File(WEBAPPS_BASE);
        File[] files = webappsRoot.listFiles();
        if(files == null){
            throw new RuntimeException();
        }

        for (File file : files){
            if(!file.isDirectory()){
                //如果不是目录，就不是web应用
                continue;
            }

            String contextName = file.getName();
            System.out.println(contextName);
            Context context = new Context(reader,contextName);
            contextsList.add(context);
        }
    }

    //针对所有 Context，需要知道有哪些 Servlet 类
    private static void parseContextConf() {
        System.out.println("第二步找到所有servlet类");
        for(Context context : contextsList){
            context.readConfigFile();
        }
    }

    //进行类加载 => 利用反射进行类加载 class文件
    private static void loadServletClasses() throws ClassNotFoundException {
        System.out.println("第三步加载class文件");
        for(Context context : contextsList){
            context.loadServletClasses();
        }
    }

    //进行实例化的过程 => 利用反射进行实例化
    private static void instantiateServletObjects() throws InstantiationException, IllegalAccessException {
        System.out.println("第四步实例化Servlet对象");
        for(Context context : contextsList){
            context.instantiateServletObjects();
        }
    }

    //调用 servlet.init() 进行初始化工作
    private static void initializeServletObjects() throws ServletException {
        System.out.println("第五步servlet初始化");
        for(Context context : contextsList){
            context.initServletObjects();
        }
    }
}
