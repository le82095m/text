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

            OutputStream outputStream = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
            PrintWriter printWriter = new PrintWriter(writer);

            Thread.sleep(5000);

            //响应行
            printWriter.println("HTTP/1.0 200 OK");
            //响应头
            printWriter.println("Content-Type:text/html;charset=utf-8");

            printWriter.println("");
            //响应体
            printWriter.println("<h1>正常工作</h1>");
            printWriter.flush();

            socket.close();
        }catch (IOException | InterruptedException e){
            e.printStackTrace(System.out);
        }
    }
}
