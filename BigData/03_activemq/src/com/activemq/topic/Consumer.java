package com.activemq.topic;

import javax.jms.JMSException;

public class Consumer implements Runnable {

    static Thread t1 = null;

    public static void main(String[] args){
        t1 = new Thread(new Consumer());
        t1.setDaemon(false); //设置为用户线程， true 为守护线程。
        t1.start();
    }


    @Override
    public void run() {
        try {
            ConsumerTools ct = new ConsumerTools();
            ct.ConsumerMessage();

            while (ct.isconnection){
                //如果连接没有断开，就一直阻塞。
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
