package com.blueice.springconditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/4/5.
 */
@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(WindowsConditional.class)
    public ListService windowsListServer(){
        return new WindowsListService();
    }


    @Bean
    @Conditional(LinuxConditional.class)
    public ListService linuxListServer(){
        return new LinuxListService();
    }

}
