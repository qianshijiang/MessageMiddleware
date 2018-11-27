package com.cn.jsm.messagemiddleware.jmsSpring.producter.consumer;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 消费者监听
 * Created by QSJ on 2018/11/27.
 */
public class ConsumerMessageListenner implements MessageListener {

    public void onMessage(Message message){
        TextMessage textMessage = (TextMessage)message;
        try{
            System.out.println("接收到消息" + textMessage.getText());
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
