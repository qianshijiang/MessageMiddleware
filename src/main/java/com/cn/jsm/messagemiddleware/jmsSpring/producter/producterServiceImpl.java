package com.cn.jsm.messagemiddleware.jmsSpring.producter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

/**
 *
 * Created by QSJ on 2018/11/22.
 */
public class producterServiceImpl implements producterService {

    @Autowired
    JmsTemplate jmsTemplate;
    @Resource(name = "queueDestination")
    Destination destination;
    public void sendMessage(String message){
        //使用JmsTemplate发送消息
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            //创建一个消息
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                return textMessage;
            }
        });
        System.out.println("发送消息"+message);

    }
}
