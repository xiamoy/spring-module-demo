package com.example.spring3.controller;

import org.springframework.stereotype.Controller;

@Controller
public class DemoController {

    public void print(){
        System.out.println("controller invoke...");
    }
}
