package com.demo.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class MultiplexerTimeServer implements Runnable{

    private Selector selector;
    private ServerSocketChannel servChannel;

    public MultiplexerTimeServer(int port) {

        try {
            selector = Selector.open();
            servChannel = ServerSocketChannel.open();

            servChannel.configureBlocking(false);
            servChannel.socket().bind(new InetSocketAddress(port),1024);
            servChannel.register(selector, Sel)


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

    }
}
