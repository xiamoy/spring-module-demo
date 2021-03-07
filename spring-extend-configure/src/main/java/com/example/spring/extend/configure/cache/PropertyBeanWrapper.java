package com.example.spring.extend.configure.cache;

import lombok.Data;

import java.lang.reflect.Field;

@Data
public class PropertyBeanWrapper {
    private String property;
    private Field field;
    private Object bean;

}
