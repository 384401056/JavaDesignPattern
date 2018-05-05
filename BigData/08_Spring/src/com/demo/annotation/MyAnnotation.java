package com.demo.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * Created by Administrator on 2018/4/21.
 */

@Target(ElementType.TYPE)  //作用于类和接口
@Retention(RetentionPolicy.RUNTIME) //VM在运行时期保留
@Component
public @interface MyAnnotation {
    String value();
}
