package com.demo.server;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;

public class ServerTask implements Runnable{

    private Socket socket;

    public ServerTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = "";

            //读取数据的方法是阻塞的。
            while ((line=br.readLine())!=null) { //按行读，意味着客户端发送的数据要有回车符，才会停止。
                System.out.println(line);
                String[] ret = line.split("\\.");
                String className = ret[0];
                String methodName = ret[1];
                try {
                    Class Clazz = Class.forName("com.demo.server." + className);  //通过class全名来获取类。
                    Object obj = Clazz.newInstance();   //创建类的实例
                    Method method = Clazz.getMethod(methodName); //通过方法名来获取方法

                    //执行方法。
                    method.setAccessible(true);
                    String result = (String) method.invoke(obj,null);
                    System.out.println(result);

                    PrintWriter pw = new PrintWriter(out);
                    pw.println(result);
                    pw.flush();


                    in.close();
                    out.close();

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
