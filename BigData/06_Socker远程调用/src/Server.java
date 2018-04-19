import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] arg) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("127.0.0.0", 8888));

        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new ServerTask(socket)).start();
        }
    }
}


