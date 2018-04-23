package com.demo.sp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/4/21.
 */
public class App {

    public static void main(String[] arg){
        new ClassPathXmlApplicationContext("com/demo/sp/spring.xml");
    }
}
