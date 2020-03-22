package com.example.spring2.config;

import com.example.spring2.external.RegistrarModel;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class ModelImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        RootBeanDefinition rbd =new RootBeanDefinition(RegistrarModel.class);
        //register beanDefinition to IOC with given beanName
        beanDefinitionRegistry.registerBeanDefinition("registerModel",rbd);
    }
}
