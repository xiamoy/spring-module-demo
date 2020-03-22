package com.example.spring2.controller;

import com.example.spring2.service.DemoService;


public class DemoController {

    private DemoService demoService;

    public DemoController(DemoService demoService){
        this.demoService=demoService;
    }

    public void init(){
        System.out.println("controller init...");
    }

    public void destroy(){
        System.out.println("controller destroy...");
    }


    public void print(){
        System.out.println("controller invoke...");
        demoService.print();
    }
}
