package com.example.spring.extend.configure.cache;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CachedAutowiredFields {

    private static Map<String, List<PropertyBeanWrapper>> fieldPropertyReferenceMap = new HashMap<>();

    private static Map<String, Object> remoteConfigPropertyMap = new HashMap<>();

    public static void put(String property, PropertyBeanWrapper propertyBeanWrapper) {
        List<PropertyBeanWrapper> propertyBeanWrappers = fieldPropertyReferenceMap.get(property);
        if (CollectionUtils.isEmpty(propertyBeanWrappers)) {
            propertyBeanWrappers = new ArrayList<>();
            fieldPropertyReferenceMap.put(property, propertyBeanWrappers);
        }
        propertyBeanWrappers.add(propertyBeanWrapper);
    }

    public static List<PropertyBeanWrapper> get(String property) {
        return fieldPropertyReferenceMap.get(property);
    }

    public static void putRemoteProperty(String key, Object value) {
        remoteConfigPropertyMap.put(key, value);
    }

    public static boolean isRemoteProperty(String key) {
        return remoteConfigPropertyMap.keySet().contains(key);
    }

}
