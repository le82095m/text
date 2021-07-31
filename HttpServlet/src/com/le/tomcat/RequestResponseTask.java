package com.le.tomcat;

import com.le.standard.Servlet;
import com.le.standard.ServletException;
import com.le.tomcat.http.HttpRequestParser;
import com.le.tomcat.http.HttpResponseSend;
import com.le.tomcat.http.Request;
import com.le.tomcat.http.Response;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class RequestResponseTask implements Runnable {
    private final Socket socket;
    public RequestResponseTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //1. 解析并得到请求对象
        try {
            InputStream inputStream = socket.getInputStream();
            HttpRequestParser httpRequestParser = new HttpRequestParser();
            Request request = httpRequestParser.parse(inputStream);

            //2. 实例化一个响应对象
            Response response = new Response();

            //3. 根据 request.getContextPath()找到哪个 Context 进行处理
            Context handleContext = ServletInitialize.getDefaultContext();
            String contextPath = request.getContextPath();
            for(String contextName : ServletInitialize.getContextMap().keySet()){
                if(contextPath.equals(contextName)){
                    handleContext = ServletInitialize.getContextMap().get(contextName);
                    break;
                }
            }

            //4. 根据 request.getServletPath()找到 Context 中的哪个 HttpServlet 进行处理
            Servlet servlet = handleContext.getServlet(request.getServletPath());
            if(servlet == null){
                servlet = ServletInitialize.getDefaultServlet();
            }

            //5. 调用 Servlet.service(request,response), 交给业务处理
            servlet.service(request,response);

            //6. 根据 response 对象中的数据，发送 HTTP 响应
            HttpResponseSend httpResponseSend = new HttpResponseSend();
            httpResponseSend.send(socket.getOutputStream(),request,response);
        } catch (IOException | ClassNotFoundException | ServletException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
