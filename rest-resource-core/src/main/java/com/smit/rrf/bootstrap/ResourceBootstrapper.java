package com.smit.rrf.bootstrap;

import com.smit.rrf.bootstrap.factory.ResourceDefinitionFactory;
import com.smit.rrf.bootstrap.scanner.ClassPathResourceScanner;
import com.smit.rrf.metadata.ResourceDefinition;
import com.smit.rrf.registry.ResourceRegistry;

import java.util.Set;

public class ResourceBootstrapper {

    private final ClassPathResourceScanner scanner;
    private final ResourceDefinitionFactory factory;
    private final ResourceRegistry registry;

    public ResourceBootstrapper(
            ClassPathResourceScanner scanner,
            ResourceDefinitionFactory factory,
            ResourceRegistry registry) {

        this.scanner = scanner;
        this.factory = factory;
        this.registry = registry;
    }

    public void bootstrap(String basePackage) {

        Set<Class<?>> classes =
                scanner.scan(basePackage);

        for (Class<?> clazz : classes) {

            ResourceDefinition definition =
                    factory.create(clazz);

            registry.register(definition);
        }
    }
}