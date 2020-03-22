package com.example.spring1.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public void print(){
        System.out.println("service invoke...");
    }
}
