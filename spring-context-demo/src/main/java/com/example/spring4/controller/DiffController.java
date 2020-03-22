package com.example.spring4.controller;

import com.example.spring4.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.util.Map;

public class DiffController {

    @Autowired
    private Map<String,DemoService> demoServiceAutowire;

    @Resource
    private Map<String,DemoService> demoServiceMapResource;

    public void print(){
        System.out.println("controller invoke...");
        System.out.println(demoServiceAutowire);
        System.out.println(demoServiceMapResource);
    }
}
