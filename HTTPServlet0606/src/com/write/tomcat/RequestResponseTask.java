package com.write.tomcat;

import com.write.standard.Servlet;
import com.write.standard.http.HttpServletResponse;
import com.write.tomcat.http.HttpRequestParser;
import com.write.tomcat.http.HttpServer;
import com.write.tomcat.http.Request;
import com.write.tomcat.http.Response;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;

public class RequestResponseTask implements Runnable {
    private static final HttpRequestParser parser = new HttpRequestParser();

    private final  Socket socket;

    public RequestResponseTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //1. 解析并得到请求对象
            Request req = parser.parse(socket.getInputStream());
            System.out.println(req);

            OutputStream os = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(os,"UTF-8");
            PrintWriter printWriter = new PrintWriter(writer);

            printWriter.printf("HTTP/1.0 200 ok\r\n");
            printWriter.printf("\r\n");
            printWriter.flush();
            //2. 实例化好一个响应对象
            HttpServletResponse resp = new Response();
            //3. 根据 request.getContextPath() 找到哪个 Context 进行处理
            Context handleContext = null;
            for(Context context : HttpServer.contextsList){
                if(context.getName().equals(req.getContextPath())){
                    handleContext = context;
                    break;
                }
            }
            //4. 根据 request.getServletPath() 找到 Context 中的哪个 HttpServlet 进行处理
            Servlet servlet = null;
            if(handleContext != null) {
                servlet = handleContext.get(req.getServletPath());
            }
            //5. 调用 servlet.service(request,response),交给业务处理
            servlet.service(req,resp);
            //6. 根据 response 对象中的数据，发送 HTTP 请求
            socket.close();
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
//        try {
//            socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
