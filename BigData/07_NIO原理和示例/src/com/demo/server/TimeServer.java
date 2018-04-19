package com.demo.server;

public class TimeServer {

    final static int PORT = 8000;

    public static void main(String[] arg){

        MultiplexerTimeServer server = new MultiplexerTimeServer(PORT);
        //只启一个线程来处理。
        new Thread(server,"NIO-MultiplexerTimeServer-0101").start();
    }


}
