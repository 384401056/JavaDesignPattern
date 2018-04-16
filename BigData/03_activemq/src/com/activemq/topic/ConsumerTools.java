package com.activemq.topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ConsumerTools implements MessageListener, ExceptionListener {

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
    private MessageConsumer consumer = null;

    public static Boolean isconnection = false;

    private void initialize() throws JMSException {
        //创建工厂类
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKER_URL);
        //创建连接
        connection = connectionFactory.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); //创建会话。
        destination = session.createTopic(SUBJECT); //关联主题。
        consumer = session.createConsumer(destination); //创建消费者。
    }

    /**
     * 消费消息
     * @throws JMSException
     */
    public void ConsumerMessage() throws JMSException {
        initialize();
        connection.start();
        consumer.setMessageListener(this);
        connection.setExceptionListener(this);
        isconnection = true;
        System.out.println("Consumer====>Begin Listener... ");
    }

    /**
     * 关闭连接
     * @throws JMSException
     */
    public void close() throws JMSException {
        System.out.println("Produce====>Closing connection");
        if(consumer!=null)
            consumer.close();
        if(session!=null)
            session.close();
        if(connection!=null)
            connection.close();
    }

    /**
     * 消息处理方法
     * @param message
     */
    @Override
    public void onMessage(Message message) {
        try {
            if(message instanceof TextMessage) {
                TextMessage txtMsg = (TextMessage) message;
                String msg = txtMsg.getText();
                System.out.println("Consumer:->Received: " + msg);
            }else{
                System.out.println("Consumer:->Received: " + message);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    /**
     * 错误处理方法
     * @param e
     */
    @Override
    public void onException(JMSException e) {
        try {
            isconnection = false;
            this.close();
        } catch (JMSException e1) {
            e1.printStackTrace();
        }
    }
}
