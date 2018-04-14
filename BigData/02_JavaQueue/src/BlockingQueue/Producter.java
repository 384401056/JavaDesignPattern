package BlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingDeque;

/**
 * Created by Administrator on 2018/4/14.
 */
public class Producter implements Runnable{

    private BlockingDeque<String> queue = null;

    public Producter(BlockingDeque<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put(Thread.currentThread().getName());
            System.out.println("I made a product: "+ Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
