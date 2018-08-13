package com.blueice.taotaoparent;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Value("${my.name}") //读取application配置文件的值
    private String name;
    @Value("${my.age}")
    private int age;

    @RequestMapping("/my")
    public String getMy(){
        return name+":"+age;
    }

}
