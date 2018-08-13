package com.blueice.taotaoparent;

import com.blueice.taotaoparent.bean.ConfigBean;
import com.blueice.taotaoparent.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@EnableConfigurationProperties({ConfigBean.class})
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "Greetings from Spring Boot!";
    }

    @Autowired
    ConfigBean configBean;

    @RequestMapping("/bean")
    public String bean(){
        return configBean.getGreeting()+" >>>>"+configBean.getName()+" >>>>"+ configBean.getUuid()+" >>>>"+configBean.getMax();
    }

    @Autowired
    User user;

    @RequestMapping("/user")
    public String getUser(){
        return user.getName()+">>>>"+user.getAge();
    }

}
