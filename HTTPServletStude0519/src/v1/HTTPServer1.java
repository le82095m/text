package v1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while(true){

            Socket socket = serverSocket.accept();
            System.out.println("一条TCP链接已经链接");

            //暂不读取/解析请求

            //直接写回响应
            OutputStream outputStream = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream,"UTF-8");
            PrintWriter printWriter = new PrintWriter(writer);

            //写响应

            //写响应行
            printWriter.printf("HTTP/1.0 200 OK\r\n");
            //写响应头
            //写入空行代表响应头结束
            printWriter.printf("\r\n");
            //写响应体,html 内容
            printWriter.printf("<h1>正常工作</h1>");
            printWriter.flush();

            socket.close();
            System.out.println("一条TCP链接已释放");
        }
    }
}
