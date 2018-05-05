package com.demo.jvmtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestThread {

    /**
     * 死循环演示
     */
    public static void createBusyThread(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("CreateBusyThread");
                while (true)
                    ;
            }
        }, "createBusyThread");
        thread.start();
    }

    /**
     * 线程等待
     * @param lock
     */
    public static void createLockThread(Object lock){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("CreateBusyThread");
                synchronized (lock){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"createLockThread");
        thread.start();
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        createLockThread(new Object());
    }


}
