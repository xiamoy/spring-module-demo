package com.example.spring4.config;

import com.example.spring4.controller.DemoController;
import com.example.spring4.controller.DiffController;
import com.example.spring4.service.DemoService;
import com.example.spring4.service.DemoServiceA;
import com.example.spring4.service.DemoServiceB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Indexed;

@Configuration
@ComponentScan("com.example.spring4")
public class AppConfig {

    @Bean
    public DemoController demoController(){
        return new DemoController();
    }

    @Bean("demoService")
    @Primary
    public DemoService demoService(){
        return new DemoServiceA();
    }

    @Bean("demoServiceB")
    public DemoService demoServiceB(){
        return new DemoServiceB();
    }

    @Bean
    public DiffController diffController(){
        return new DiffController();
    }

}
