package com.demo.client;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] arg) throws IOException {

        Socket socket = new Socket("localhost", 8888);

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        PrintWriter pw = new PrintWriter(out);
        pw.println("ServerAPI.getData");
        pw.flush();
        System.out.println("send data finish.");

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String resutl = br.readLine();
        System.out.println(resutl);

        out.close();
        in.close();
        socket.close();
    }
}
