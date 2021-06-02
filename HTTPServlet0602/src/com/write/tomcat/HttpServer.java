package com.write.tomcat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = new ServerSocket(8080);

        //1. 找到所有的 Servlet 对象，进行初始化
        initServer();

        //2. 每次循环，处理一个请求
        while (true){
            Socket socket = serverSocket.accept();
            Runnable task = new RequestResponseTask(socket);
            threadPool.execute(task);
        }

        //3. 找到所有的 Servlet 对象，进行销毁
    }

    private static void initServer() {
        scanContexts();
        //1. 扫描所有 Context (执行目录扫描)
        parseContextConf();
        //2. 针对所有 Context，需要知道有哪些 Servlet 类
//        loadServletClasses();
        //3.进行类加载 => 利用反射进行类加载 class文件
//        instantiateServletObjects();
        //4.进行实例化的过程 => 利用反射进行实例化
//        initializeServletObjects();
        //5.调用 servlet.init() 进行初始化工作
    }

    private static final String WEBAPPS_BASE = "D:\\JavaDemo\\HTTPServlet\\webapps";
    private static final List<Context> contextsList = new ArrayList<>();
    private static void scanContexts() {
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
            Context context = new Context(contextName);
            contextsList.add(context);
        }
    }

    private static void parseContextConf() {
        for(Context context : contextsList){
            //进行 web.conf 文件的读取+解析

            //web.conf 放哪里，必须符合规范，否则就会读不到
            String filename = String.format("%s%s/WEF-INF/web.conf",WEBAPPS_BASE,context.getname());

            String stage = "start";//"servlets"/"mappings"

            //进行文本文件的读取
            try(InputStream is = new FileInputStream(filename)){
                Scanner scanner = new Scanner(is,"UTF-8");
                while(scanner.hasNextLine()){
                    String line = scanner.nextLine().trim();
                    System.out.println(line);
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
                            if(line.equals("servlet-mappings")){
                                stage = "mappings";
                            }else{
                                //进行 ServletName => ServletClassName 的解析
                            }
                            break;
                        case "mappings":
                            //进行URL => ServletName 的解析
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //进行配置文件的解析工作
        }
    }
}
