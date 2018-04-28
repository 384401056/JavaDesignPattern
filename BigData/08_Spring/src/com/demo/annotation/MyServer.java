package com.demo.annotation;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Administrator on 2018/4/21.
 */
@Component
public class MyServer implements ApplicationContextAware {


    public static void main(String[] arg){
        new ClassPathXmlApplicationContext("com/demo/annotation/spring.xml");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //通过ApplicationContext获取MyAnnotaion注解的类
        Map<String, Object> serviceBeanMap = applicationContext.getBeansOfType(B.class);
        for (Object bean:serviceBeanMap.values()){
            System.out.println(bean.toString());
        }
    }
}
