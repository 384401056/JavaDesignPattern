package com.demo.sp;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/4/21.
 */

@Component
public class Three {

    public Three() {
        System.out.println("Three");
    }

    public Three(String name){
        System.out.println(name);
    }
}
