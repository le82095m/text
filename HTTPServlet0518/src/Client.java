import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8080);
        // socket 已经建立好连接了

        OutputStream outputStream = socket.getOutputStream();
        Writer writer = new OutputStreamWriter(outputStream,"UTF-8");
        PrintWriter printWriter = new PrintWriter(writer);

        printWriter.printf("你好，HTTP\r\n");//向服务器发送消息
        printWriter.flush(); //只有进行了刷新操作，才能真正发送


        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(inputStream,"UTF-8");

        String message = scanner.nextLine();// 从服务器读取消息
        System.out.println(message);

        socket.close();

    }
}
