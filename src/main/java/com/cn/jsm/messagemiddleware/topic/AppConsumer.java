package com.cn.jsm.messagemiddleware.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 创建消费者(必须先订阅主题才能接收到消息,订阅之前发送的消息是接收不到的)
 * Created by QSJ on 2018/11/22.
 */
public class AppConsumer {

    private static final String url = "tcp://127.0.0.1:61616"; //服务地址

    private static final String topicName = "topic-test"; //队列名字

    public static void main(String args[]) throws Exception{
        // 1.创建ConnectionFactory 连接工厂

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

        // 2.创建连接Conncetion

        Connection connection = connectionFactory.createConnection();

        // 3.启动连接

        connection.start();

        // 4.创建会话 Session

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); //第一个参数：是否在事务中处理;第二个参数表示自动应答

        // 5. 创建一个目标

        Destination destination = session.createTopic(topicName);

        // 6. 创建一个消费者

        MessageConsumer messageConsumer = session.createConsumer(destination);

        // 7.创建一个监听器

        messageConsumer.setMessageListener(new MessageListener(){

            public void onMessage(Message message){
                TextMessage textMessage = (TextMessage) message;
                try{
                    System.out.println("接收消息" + textMessage.getText());
                }catch (JMSException e){
                    e.printStackTrace();
                }
            }
        });

        // 8. 关闭连接
        //connection.close();


    }
}
