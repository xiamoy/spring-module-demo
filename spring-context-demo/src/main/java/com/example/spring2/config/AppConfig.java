package com.example.spring2.config;

import com.example.spring2.condition.BeanCreatorCodition;
import com.example.spring2.controller.DemoController;
import com.example.spring2.dao.DemoDAO;
import com.example.spring2.external.ModelA;
import com.example.spring2.service.DemoService;
import org.springframework.context.annotation.*;

@Configuration
@Import({ModelA.class,ModelImportSelector.class,ModelImportBeanDefinitionRegistrar.class})
public class AppConfig {

    @Bean
    @Primary
    @DependsOn({"demoDAO"})
    public DemoService demoService(){
        return new DemoService();
    }

    @Bean(initMethod = "init",destroyMethod = "destroy")
    @Conditional(value = {BeanCreatorCodition.class})
    public DemoController demoController(){
        return new DemoController(demoService());
    }

    @Bean
    public DemoDAO demoDAO(){
        return new DemoDAO();
    }
    @Bean
    public String modelAName(){
        return "modelA_name";
    }
}
