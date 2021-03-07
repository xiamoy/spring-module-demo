package com.example.web.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/config")
public class ConfigDataController {

    RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/data")
    public Map<String, Object> getConfig() {
        Map<String, Object> configMap = new HashMap<>();
        configMap.put("config.key", "redis-config");
        configMap.put("config.value", "XcvweaQa");

        String multiCcy = "USD,AUD,GBR,JPY";
        configMap.put("config.ccy", multiCcy);

        List<String> ccyList = new ArrayList<>();
        ccyList.add("USD");
        ccyList.add("AUD");
        ccyList.add("GBR");
        ccyList.add("JPY");
        configMap.put("config.list", ccyList.toString());

        return configMap;
    }

}
