package com.example.spring.extend.configure.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CachedRemoteProperties {

    private static Map<String, Object> map = new ConcurrentHashMap<>();

    public static Object get(String key) {
        return map.get(key);
    }

    public static void put(String key, Object value) {
        map.put(key, value);
    }

    public static Map<String, Object> cloneCurrentLoadedRemoteProperty() {
        return new HashMap<>(map);
    }
}
