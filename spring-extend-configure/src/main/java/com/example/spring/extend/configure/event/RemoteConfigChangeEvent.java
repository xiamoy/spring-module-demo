package com.example.spring.extend.configure.event;

import org.springframework.context.ApplicationEvent;

import java.util.Map;

public class RemoteConfigChangeEvent extends ApplicationEvent {

    public RemoteConfigChangeEvent(Map<String, Object> source) {
        super(source);
    }

    @Override
    public Map<String, Object> getSource() {
        return (Map<String, Object>) super.getSource();
    }
}
