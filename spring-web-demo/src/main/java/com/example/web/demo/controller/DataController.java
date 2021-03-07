package com.example.web.demo.controller;

import com.example.web.demo.LogUtil;
import com.example.web.demo.entity.User;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class DataController {

    Logger logger = LogManager.getLogger(DataController.class);
    Gson gson = new Gson();

    @RequestMapping("/data")
    public String sendData() {
        String id = UUID.randomUUID().toString();
        String message = "hello, new message";
        Date now = new Date();
        boolean isNewMessage = now.getTime() % 2 == 0;

        Map<String, Object> data = new HashMap<>();
        data.put("id", id);
        data.put("text", message);
        data.put("now", now);
        String url = "http://localhost:8080/data";
        data.put("url", url);
        data.put("isNewMessage", isNewMessage);
        data.put("type", "statistics");
        Map<String, Object> inner = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH::mmm:ss");
        String start = sdf.format(new Date());
        inner.put("start", start);

        User user = new User();
        user.setAge(12);
        user.setName("Visa");
        user.setSalary(1234.4);
        user.setNewEmployee(true);
        inner.put("user", user);
        data.put("inner", inner);
        LogUtil.logging(gson.toJson(data));

        return "success";
    }
}

