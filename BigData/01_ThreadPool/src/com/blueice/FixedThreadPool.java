package com.blueice;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

public class FixedThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程池，固定数量线程池。
        ExecutorService pool = Executors.newFixedThreadPool(5);

//        //当创建线程线大于固定数量时，会等待其它线程执行完毕，才会创建新的线程。
//        for (int i = 0;i<5;i++) {
//            //Runnable的run方法是不会有任何返回结果的。
//            //Callable的call方法是有返回结果的。但主机线程在获取结果submit.get()时是被阻塞的。如果不想被阻塞就先将结果存起来。最后再来get()
//            Future<String> submit = pool.submit(new Callable<String>() {
//                @Override
//                public String call() throws Exception {
//                    Thread.sleep(2000);
//                    return "currentThread: " + Thread.currentThread();
//                }
//            });
//            System.out.println(submit.get());
//        }

        ArrayList<Future<?>> results = new ArrayList<Future<?>>();

        for (int i = 0;i<10;i++) {
            Future<String> submit = pool.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {

                    Random r = new Random();
                    Thread.sleep(r.nextInt(10)*10000);
                    return "currentThread: " + Thread.currentThread();
                }
            });
            results.add(submit);
        }

        pool.shutdown();

        for(Future f:results){
            boolean done = f.isDone();
            System.out.println(done?"已经完成！":"未完成。");
            System.out.println("线程返回结果:"+f.get());
        }

    }
}
