package com.cn.jsm.messagemiddleware.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 队列模式
 * Created by QSJ on 2018/11/22.
 */
public class AppProducer {

    private static final String url = "tcp://127.0.0.1:61616"; //服务地址

    private static final String queueName = "queue-test"; //队列名字

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

        Destination destination = session.createQueue(queueName);

       // 6. 创建一个生产者

        MessageProducer producer = session.createProducer(destination);

        //7. 创建消息
        for(int i=0;i<100;i++){
            TextMessage textMessage = session.createTextMessage("test" + i);
            // 8. 发送消息
            producer.send(textMessage);
            System.out.println("第"+i+"条消息发送成功");
        }

        // 9. 关闭连接
        connection.close();
    }
}
