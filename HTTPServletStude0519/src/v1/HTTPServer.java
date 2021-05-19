package v1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while(true){
            Socket socket = serverSocket.accept();

            Runnable task = new RequestResponseTask(socket);
            new Thread(task).start();
        }
    }
}
