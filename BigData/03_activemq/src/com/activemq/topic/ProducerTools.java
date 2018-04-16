package com.activemq.topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;

public class ProducerTools {

    //ActiveMq 的默认用户名
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //ActiveMq 的默认登录密码
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //ActiveMQ 的链接地址
    private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    //消息主题名称。
    private static final String SUBJECT = "MyTopic";

    private Destination destination = null;
    private Connection connection = null;
    private Session session = null;
    private MessageProducer producer = null;

    /**
     * 初始化
     *
     * @throws JMSException
     */
    private void initialize() throws JMSException {
        //创建工厂类
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKER_URL);
        //创建连接
        connection = connectionFactory.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); //创建会话。
        destination = session.createTopic(SUBJECT); //关联主题。
        producer = session.createProducer(destination); //创建生产者。
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);  //送达模式。NON_PERSISTENT非持久化。
    }

    /**
     * 发送消息
     * @param message
     */
    public void produceMessage(String message) throws JMSException {
        initialize();
        //创建文本消息。
        TextMessage msg = session.createTextMessage(message);
        connection.start();
        System.out.println("Produce====>Sending Message: " + message);
        producer.send(msg);
        System.out.println("Produce====>Message send complete: " + message);
    }

    /**
     * 关闭连接
     * @throws JMSException
     */
    public void close() throws JMSException {
        System.out.println("Produce====>Closing connection");
        if(producer!=null)
            producer.close();
        if(session!=null)
            session.close();
        if(connection!=null)
            connection.close();
    }
}
