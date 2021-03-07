package com.example.web.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


@SpringBootApplication
@RestController
@EnableFeignClients
public class WebApp {

    public static void main(String[] args) {
        SpringApplication.run(WebApp.class);

//        List<String> ccyList =new ArrayList<>();
//        ccyList.add("USD");
//        ccyList.add("AUD");
//        ccyList.add("GBR");
//        ccyList.add("JPY");
//        System.out.println(ccyList.toString());
    }

    @RequestMapping("/version.txt")
    public File getFile() {
        File file = new File("version.txt");
        String verion = "100";
        byte[] bytes = verion.getBytes();


        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }
}
