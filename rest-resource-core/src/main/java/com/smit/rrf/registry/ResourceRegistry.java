package com.smit.rrf.registry;

import com.smit.rrf.metadata.ResourceDefinition;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ResourceRegistry {

    private final Map<Class<?>, ResourceDefinition> resources =
            new ConcurrentHashMap<>();

    public void register(ResourceDefinition metadata) {
        resources.put(metadata.getEntityClass(), metadata);
    }

    public ResourceDefinition get(Class<?> entityClass) {
        return resources.get(entityClass);
    }

    public Collection<ResourceDefinition> getAll() {
        return resources.values();
    }
}