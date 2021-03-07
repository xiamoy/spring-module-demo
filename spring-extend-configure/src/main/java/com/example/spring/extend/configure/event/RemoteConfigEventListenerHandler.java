package com.example.spring.extend.configure.event;

import com.example.spring.extend.configure.cache.CachedAutowiredFields;
import com.example.spring.extend.configure.cache.PropertyBeanWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@Slf4j
public class RemoteConfigEventListenerHandler implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("onApplicationEvent type:{}", event.getClass().getName());
        if (event instanceof RemoteConfigChangeEvent) {
            RemoteConfigChangeEvent remoteConfigChangeEvent = (RemoteConfigChangeEvent) event;
            Map<String, Object> source = remoteConfigChangeEvent.getSource();
            if (!CollectionUtils.isEmpty(source)) {
                Set<String> propertySets = source.keySet();
                for (String propKey : propertySets) {
                    List<PropertyBeanWrapper> propertyBeanWrappers = CachedAutowiredFields.get(propKey);
                    if (!CollectionUtils.isEmpty(propertyBeanWrappers)) {
                        Object newValue = source.get(propKey);
                        for (PropertyBeanWrapper item : propertyBeanWrappers) {
                            try {
                                switch (item.getAutowireType()) {
                                    case Field:
                                        item.getField().set(item.getBean(), newValue);
                                        break;
                                    case Method:
                                        item.getMethod().invoke(item.getBean(), new Object[]{newValue});
                                        break;
                                }

                            } catch (IllegalAccessException e) {
                                log.error("failed to set filed property for {}", item);
                            } catch (InvocationTargetException e) {
                                log.error("failed to invoke method property for {}", item);
                            }
                        }
                    }
                }

            }

        }
    }
}
