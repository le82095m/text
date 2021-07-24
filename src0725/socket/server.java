package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            //通过 socket 向OS要已经建立的TCP连接
            Socket socket = serverSocket.accept();
            System.out.println("有一条TCP连接已建立");
            //通过调用accept，进行三次握手

            InputStream inputStream = socket.getInputStream();
            //通过inputStream，读取Client发送过来的应用层数据
            Scanner scanner = new Scanner(inputStream, "UTF-8");
            String str = scanner.nextLine();
            System.out.println(str);

            OutputStream outputStream = socket.getOutputStream();
            //通过将数据写入outputStream,经过OS内部的TCP机制，将数据发送给 client
            Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.println("你好我是服务端\r\n");
            printWriter.flush();

            socket.close();
            //触发TCO四次挥手
        }
    }
}
