package com.example.spring.extend.configure.extend;

import com.example.spring.extend.configure.cache.CachedRemoteProperties;
import org.springframework.core.env.PropertySource;
import org.springframework.util.CollectionUtils;

import java.util.Map;

public class RemotePropertySource extends PropertySource<Map> {

    public RemotePropertySource(String name, Map source) {
        super(name, source);
    }

    public RemotePropertySource(String name) {
        super(name);
    }

    @Override
    public Object getProperty(String s) {
//        if (!CollectionUtils.isEmpty(source)){
//            Object value = source.get(s);
//            if (value!=null){
//                return value;
//            }
//        }
        return CachedRemoteProperties.get(s);
    }
}
