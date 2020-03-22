package com.example.spring3.service;

import org.springframework.stereotype.Service;

@Service
public class ExtendsService extends AbstractService{

    public void print(){
        System.out.println("service invoke...");
    }
}
