package com.example;

import com.example.spring4.config.AppConfig;
import com.example.spring4.controller.DemoController;
import com.example.spring4.controller.DiffController;
import com.example.spring4.service.DemoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanName:beanDefinitionNames             ) {
            System.out.println(beanName+":"+context.getBean(beanName));
        }
        long end =System.currentTimeMillis();
        System.out.println("cost:"+(end-start));

        DemoController demoController = context.getBean(DemoController.class);
        demoController.print();
        DemoService demoService = context.getBean(DemoService.class);
        demoService.print();
        DiffController diffController = context.getBean(DiffController.class);
        diffController.print();

    }
}
