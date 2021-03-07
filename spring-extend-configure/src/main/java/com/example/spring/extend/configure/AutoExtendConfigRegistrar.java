package com.example.spring.extend.configure;

import com.example.spring.extend.configure.extend.ExtendAutowiredAnnotationBeanPostProcessor;
import com.example.spring.extend.configure.utils.RegUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static org.springframework.context.annotation.AnnotationConfigUtils.AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME;

public class AutoExtendConfigRegistrar implements ImportBeanDefinitionRegistrar,
        ApplicationContextAware, EnvironmentAware, ResourceLoaderAware {

    ApplicationContext context;
    Environment env;
    ResourceLoader resourceLoader;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        if (registry instanceof DefaultListableBeanFactory) {
//            spring.main.allow-bean-definition-overriding=true
            ((DefaultListableBeanFactory) registry).setAllowBeanDefinitionOverriding(true);
        }

        ClassPathBeanDefinitionScanner beanDefinitionScanner =
                new ClassPathBeanDefinitionScanner(registry, false);
        if (!(registry instanceof ResourceLoader)) {
            beanDefinitionScanner.setResourceLoader(resourceLoader);
        }
        beanDefinitionScanner.addIncludeFilter(new TypeFilter() {
            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
                return annotationMetadata.hasAnnotation(Component.class.getName());
            }
        });

        beanDefinitionScanner.scan("com.example.spring.extend.configure");


        if (registry.containsBeanDefinition(AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME)) {
            RootBeanDefinition def = new RootBeanDefinition(ExtendAutowiredAnnotationBeanPostProcessor.class);
            registry.registerBeanDefinition(AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME, def);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setting context");
        this.context = applicationContext;

    }

    @Override
    public void setEnvironment(Environment environment) {//set before resource loader at org.springframework.context.annotation.ParserStrategyUtils.invokeAwareMethods
        System.out.println("setting environment");
        this.env = environment;
        String clientApplication = environment.getProperty("config.client.application.name");
        String remoteConfigUrl = environment.getProperty("config.server.url");
        System.out.println("clientApplication:" + clientApplication + ",remoteConfigUrl:" + remoteConfigUrl);
        RegUtils.setUrl(remoteConfigUrl);
        RegUtils.initializeConfigFromRemote();
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
