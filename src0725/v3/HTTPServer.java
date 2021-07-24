package v3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HTTPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                10,
                20,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r);
                    }
                },
                new ThreadPoolExecutor.DiscardPolicy());

        int i = 0;
        while(i < 100){
            Socket socket = serverSocket.accept();

            Runnable task = new RequestResponseTask(socket);
            pool.execute(task);
            i++;
        }

        pool.shutdown();
    }
}
