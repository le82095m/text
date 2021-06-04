package com.write.tomcat;

import com.write.tomcat.http.HttpRequestParser;
import com.write.tomcat.http.Request;

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
//            //2. 实例化好一个响应对象
//            HttpServletResponse resp = null;
//            //3. 根据 request.getContextPath() 找到哪个 Context 进行处理
//            Context context = null;
//            //4. 根据 request.getServletPath() 找到 Context 中的哪个 HttpServlet 进行处理
//            Servlet servlet = null;
//            //5. 调用 servlet.service(request,response),交给业务处理
//            try {
//                servlet.service(req, resp);
//            } catch (ServletException | IOException e) {
//                e.printStackTrace();
//            }
            //6. 根据 response 对象中的数据，发送 HTTP 请求
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
