package com.smit.rrf.registry;

import com.smit.rrf.metadata.ResourceMetadata;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ResourceRegistry {

    private final Map<Class<?>, ResourceMetadata> resources =
            new ConcurrentHashMap<>();

    public void register(ResourceMetadata metadata) {
        resources.put(metadata.getEntityClass(), metadata);
    }

    public ResourceMetadata get(Class<?> entityClass) {
        return resources.get(entityClass);
    }

    public Collection<ResourceMetadata> getAll() {
        return resources.values();
    }
}