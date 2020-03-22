package com.example.spring1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Indexed;

@Indexed
@Configuration
@ComponentScan("com.example.spring1")
public class AppConfig {
}
