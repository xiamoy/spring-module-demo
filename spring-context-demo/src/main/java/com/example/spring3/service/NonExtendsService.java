package com.example.spring3.service;

import org.springframework.stereotype.Service;

@Service
public class NonExtendsService{

    public void print(){
        System.out.println("service invoke...");
    }
}
