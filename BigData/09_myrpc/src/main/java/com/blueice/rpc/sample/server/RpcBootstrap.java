package com.blueice.rpc.sample.server;

import org.reflections.Reflections;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Map;


public class RpcBootstrap implements ApplicationContextAware {

    public static void main(String[] arg){
        new ClassPathXmlApplicationContext("com/blueice/rpc/sample/server/spring.xml");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> classesList = applicationContext.getBeansWithAnnotation(RpcService.class);
        for (Object obj:classesList.values()){
            System.out.println(obj);
        }
    }
}
