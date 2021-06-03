package com.write.tomcat;

import com.write.standard.Servlet;
import com.write.standard.ServletException;
import com.write.standard.http.HttpServletRequest;
import com.write.standard.http.HttpServletResponse;

import javax.naming.Context;
import java.io.IOException;
import java.net.Socket;

public class RequestResponseTask implements Runnable {
    private final  Socket socket;

    public RequestResponseTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //1. 解析并得到请求对象
        HttpServletRequest request = null;
        //2. 实例化好一个响应对象
        HttpServletResponse response = null;
        //3. 根据 request.getContextPath() 找到哪个 Context 进行处理
        Context context = null;
        //4. 根据 request.getServletPath() 找到 Context 中的哪个 HttpServlet 进行处理
        Servlet servlet = null;
        //5. 调用 servlet.service(request,response),交给业务处理
        try {
            servlet.service(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //6. 根据 response 对象中的数据，发送 HTTP 请求
    }
}
