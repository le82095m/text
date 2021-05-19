package v1;

import java.io.*;
import java.net.Socket;

public class RequestResponseTask implements Runnable{
    private final Socket socket;

    public RequestResponseTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("一条TCP链接已连接");
            //暂不读取/解析请求

            Thread.sleep(10000);
            //直接写回响应
            OutputStream outputStream = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream,"UTF-8");
            PrintWriter printWriter = new PrintWriter(writer);

            //写响应

            //写响应行
            printWriter.printf("HTTP/1.0 200 OK\r\n");
            //写响应头
            printWriter.printf("Content-Type: text/html; charset=utf-8\r\n");
            //写入空行代表响应头结束
            printWriter.printf("\r\n");
            //写响应体,html 内容
            printWriter.printf("<h1>正常工作</h1>");
            printWriter.flush();
        }catch (IOException | InterruptedException e){
            //因为单次的请求响应周期错误，不应该影响其他请求响应周期
            e.printStackTrace(System.out);
        }finally {
            try {
                 socket.close();
                System.out.println("一条TCP链接已释放");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
