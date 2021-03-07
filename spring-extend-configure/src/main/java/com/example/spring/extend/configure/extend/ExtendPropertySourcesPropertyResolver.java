package com.example.spring.extend.configure.extend;

import com.example.spring.extend.configure.cache.CachedAutowiredFields;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.PropertySources;
import org.springframework.core.env.PropertySourcesPropertyResolver;
import org.springframework.lang.Nullable;


public class ExtendPropertySourcesPropertyResolver extends PropertySourcesPropertyResolver {

//    private Map<String,Object> remoteFoundPropertyMap =new HashMap();

    @Nullable
    private final PropertySources propertySources;

    public ExtendPropertySourcesPropertyResolver(PropertySources propertySources) {
        super(propertySources);
        this.propertySources = propertySources;
    }

    @Nullable
    protected <T> T getProperty(String key, Class<T> targetValueType, boolean resolveNestedPlaceholders) {
        if (this.propertySources != null) {
            for (PropertySource<?> propertySource : this.propertySources) {
                if (logger.isTraceEnabled()) {
                    logger.trace("Searching for key '" + key + "' in PropertySource '" +
                            propertySource.getName() + "'");
                }
                Object value = propertySource.getProperty(key);
                if (value != null) {
                    if (resolveNestedPlaceholders && value instanceof String) {
                        value = resolveNestedPlaceholders((String) value);
                    }
                    logKeyFound(key, propertySource, value);
                    T result = convertValueIfNecessary(value, targetValueType);
                    if (propertySource.getName().equals(ExtendPropertySourcesPlaceholderConfigurer.REMOTE_PROPERTIES_PROPERTY_SOURCE_NAME)) {
                        CachedAutowiredFields.putRemoteProperty(key, value);
                    }
                    return result;
                }
            }
        }
        if (logger.isTraceEnabled()) {
            logger.trace("Could not find key '" + key + "' in any property source");
        }
        return null;
    }

//    public Map<String, Object> getRemoteFoundPropertyMap() {
//        return remoteFoundPropertyMap;
//    }
//
//    public void setRemoteFoundPropertyMap(Map<String, Object> remoteFoundPropertyMap) {
//        this.remoteFoundPropertyMap = remoteFoundPropertyMap;
//    }
}
