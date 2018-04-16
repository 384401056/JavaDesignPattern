package com.blueice;

import java.util.concurrent.*;

public class CachedThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程池，可回收线程池。
        ExecutorService pool = Executors.newCachedThreadPool();

        //创建线程，并执行任务。
        for (int i = 0;i<20;i++) {
            //创建线程，并执行任务。Runnable的run方法是不会有任何返回结果的。
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("currentThread: " + Thread.currentThread());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        pool.shutdown();
    }
}
