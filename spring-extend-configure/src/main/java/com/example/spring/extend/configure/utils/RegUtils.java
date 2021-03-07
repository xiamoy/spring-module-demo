package com.example.spring.extend.configure.utils;

import com.example.spring.extend.configure.cache.CachedRemoteProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class RegUtils {

    static RestTemplate restTemplate = new RestTemplate();
    static String url;

    public static void initializeConfigFromRemote() {
        System.out.println("getting config from remote...");
        ResponseEntity<Map> responseEntity = restTemplate.getForEntity(url, Map.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            Map<String, Object> body = responseEntity.getBody();
            body.forEach((k, v) -> CachedRemoteProperties.put(k, v));
        } else {
            System.out.println("getting initializing remote config failed:" + responseEntity.getStatusCode());
        }

    }

    public static void setUrl(String remoteConfigUrl) {
        url = remoteConfigUrl;
    }
}
