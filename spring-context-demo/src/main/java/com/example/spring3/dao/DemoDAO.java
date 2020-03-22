package com.example.spring3.dao;

import org.springframework.stereotype.Repository;

@Repository
public class DemoDAO {

    public void print(){
        System.out.println("dao invoke...");
    }
}
