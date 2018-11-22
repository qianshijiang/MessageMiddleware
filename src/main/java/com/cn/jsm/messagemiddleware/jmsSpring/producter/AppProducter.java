package com.cn.jsm.messagemiddleware.jmsSpring.producter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动类
 * Created by QSJ on 2018/11/22.
 */
public class AppProducter {

    public static void main(String []args){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("producter.xml");
        producterService service = applicationContext.getBean(producterServiceImpl.class);

        for(int i=0;i<100;i++){
            service.sendMessage("test" + i);
        }
        applicationContext.close();
    }
}
