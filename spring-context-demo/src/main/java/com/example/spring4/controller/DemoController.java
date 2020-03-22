package com.example.spring4.controller;

import com.example.spring4.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class DemoController {

    @Autowired
    private DemoService demoService1; //DemoServiceA

    @Autowired
    @Qualifier("demoServiceB")
    private DemoService demoService2;//DemoServiceB

    @Resource(name = "demoServiceB")
    private DemoService demoService3;//DemoServiceB

    public void print(){
        System.out.println("controller invoke...");
        demoService1.print();
        demoService2.print();
        demoService3.print();
    }
}
