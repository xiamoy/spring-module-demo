package com.example.spring.extend.configure.cache;

import lombok.Data;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


@Data
public class PropertyBeanWrapper {
    private String property;
    private Field field;
    private Object bean;
    private Method method;
    private AutowireType autowireType = AutowireType.Field;
}
