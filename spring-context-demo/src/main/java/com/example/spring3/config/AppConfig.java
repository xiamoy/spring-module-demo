package com.example.spring3.config;

import com.example.spring3.service.AbstractService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;


@Configuration
@ComponentScan(value = {"com.example.spring3"},
        includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, CustomAnno.class}),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {AbstractService.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {CustomFilter.class})
},excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})},
        useDefaultFilters = false)
public class AppConfig {

}
