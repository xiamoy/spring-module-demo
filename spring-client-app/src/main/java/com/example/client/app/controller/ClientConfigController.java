package com.example.client.app.controller;

import com.example.spring.extend.configure.event.RemoteConfigChangeEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientConfigController implements ApplicationEventPublisherAware {

    ApplicationEventPublisher applicationEventPublisher;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${config.key}")
    private String configKey;

    @Value("#{'${config.ccy}'.split(',')}")
    private String[] ccyArray;

    private String configValue;
    private String initer;

    public String getConfigValue() {
        return configValue;
    }

    public ClientConfigController(@Value("${config.ccy}") String configCcy) {
        this.initer = configCcy;
    }

    @Value("${config.value}")
    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    //    @Value("#{${test.map}}")
//    private Map<String, Object> testMap;

    @RequestMapping("/config")
    public Object getConfig() {
        System.out.println("configKey:" + configKey);
        System.out.println("configCcy:" + ccyArray);
        System.out.println("configValue:" + configValue);
        System.out.println("applicationName:" + applicationName);
        return configKey;
    }

    @RequestMapping("/change")
    public String change() {
        Map<String, Object> map = new HashMap<>();
        map.put("config.key", "mongo-config");
        map.put("config.ccy", "CNY,EUR,AUD,FRY");
        map.put("config.value", "abcde");
        RemoteConfigChangeEvent remoteConfigChangeEvent = new RemoteConfigChangeEvent(map);
        applicationEventPublisher.publishEvent(remoteConfigChangeEvent);
        return "Published";
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
