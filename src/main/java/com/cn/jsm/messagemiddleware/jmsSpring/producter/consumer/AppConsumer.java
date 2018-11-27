package com.cn.jsm.messagemiddleware.jmsSpring.producter.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 消费者启动类
 * Created by QSJ on 2018/11/27.
 */
public class AppConsumer {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");

    }
}
