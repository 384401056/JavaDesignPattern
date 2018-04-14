package BlockingQueue;

import java.util.concurrent.BlockingDeque;

/**
 * Created by Administrator on 2018/4/14.
 */
public class Consumer implements Runnable{

    private BlockingDeque<String> queue = null;

    public Consumer(BlockingDeque<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println("Cunsumer try....");
            String ret = queue.take();
            System.out.println("Cunsumer get product: "+ret);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
