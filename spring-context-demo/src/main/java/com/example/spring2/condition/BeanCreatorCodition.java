package com.example.spring2.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class BeanCreatorCodition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //get property/profile from environment
        Environment environment = conditionContext.getEnvironment();
        //get bean info from beanFactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //get annotated attribute info from AnnotatedTypeMetadata
        Map<String, Object> attributes = annotatedTypeMetadata.getAnnotationAttributes(Bean.class.getName());
        if (attributes.get("initMethod")!=null){
            return true;
        }
        return false;
    }
}
