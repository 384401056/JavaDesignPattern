package cn.live.hunterofheart;

import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.net.InetSocketAddress;


public class Main {

    /** Choose your favorite port number. */
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        SocketAcceptor acceptor = new NioSocketAcceptor();
        System.out.println( "Listening on port " + PORT );
    }
}
