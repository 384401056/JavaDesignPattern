package BlockingQueue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Administrator on 2018/4/14.
 */
public class MyApplication {

    public static void main(String[] arg){

        BlockingDeque<String> queue = new LinkedBlockingDeque<String>(2);

        for(int i=0;i<3;i++){
            new Thread(new Producter(queue)).start();
        }

        for(int i=0;i<5;i++){
            new Thread(new Consumer(queue)).start();
        }

    }
}
