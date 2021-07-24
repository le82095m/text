package socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8080);

        InputStream inputStream = socket.getInputStream();
        //通过inputStream，读取Client发送过来的应用层数据
        Scanner scanner = new Scanner(inputStream,"UTF-8");


        OutputStream outputStream = socket.getOutputStream();
        //通过将数据写入outputStream,经过OS内部的TCP机制，将数据发送给 client
        Writer writer = new OutputStreamWriter(outputStream,"UTF-8");
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.println("你好我是客户端\r\n");
        printWriter.flush();


        String message = scanner.nextLine();
        System.out.println(message);
        socket.close();
    }
}
