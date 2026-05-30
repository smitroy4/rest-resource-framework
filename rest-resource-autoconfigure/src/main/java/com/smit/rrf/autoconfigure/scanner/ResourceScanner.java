package com.smit.rrf.autoconfigure.scanner;

import com.smit.rrf.annotations.RestResource;
import com.smit.rrf.metadata.ResourceMetadata;
import com.smit.rrf.registry.ResourceRegistry;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;

public class ResourceScanner
        implements SmartInitializingSingleton {

    private final ApplicationContext context;
    private final ResourceRegistry registry;

    public ResourceScanner(
            ApplicationContext context,
            ResourceRegistry registry) {

        this.context = context;
        this.registry = registry;
    }

    @Override
    public void afterSingletonsInstantiated() {

        String[] beanNames =
                context.getBeanDefinitionNames();

        for (String beanName : beanNames) {

            Object bean;

            try {
                bean = context.getBean(beanName);
            } catch (Exception ex) {
                continue;
            }

            Class<?> clazz = bean.getClass();

            if (!clazz.isAnnotationPresent(RestResource.class)) {
                continue;
            }

            RestResource annotation =
                    clazz.getAnnotation(RestResource.class);

            ResourceMetadata metadata =
                    new ResourceMetadata(
                            clazz,
                            annotation.dto(),
                            annotation.path(),
                            annotation.pageable(),
                            annotation.sortable(),
                            annotation.searchable()
                    );

            registry.register(metadata);
        }
    }
}