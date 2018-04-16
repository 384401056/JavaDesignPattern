package com.activemq.topic;

import javax.jms.*;

public class Producer {

    public static void main(String[] args) throws InterruptedException, JMSException {
        ProducerTools pt = new ProducerTools();
        //每三秒产生一条消息
        for(int i=0;i<20;i++){
            Thread.sleep(3*1000);
            pt.produceMessage("hello ActiveMQ"+i);
            pt.close();
        }
    }

}





















