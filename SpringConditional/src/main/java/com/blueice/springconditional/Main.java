package com.blueice.springconditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 2017/4/5.
 */
public class Main {
    public static void main(String[] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);

        ListService listenServer = context.getBean(ListService.class);

        System.out.println(listenServer.showListCmd());

        context.close();

    }
}
