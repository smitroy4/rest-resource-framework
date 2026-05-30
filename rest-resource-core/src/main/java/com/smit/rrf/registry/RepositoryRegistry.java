package com.smit.rrf.registry;

import com.smit.rrf.metadata.RepositoryDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RepositoryRegistry {

    private final Map<Class<?>, RepositoryDefinition> repositories =
            new ConcurrentHashMap<>();

    public void register(RepositoryDefinition definition) {
        repositories.put(
                definition.getEntityClass(),
                definition
        );
    }

    public RepositoryDefinition get(Class<?> entityClass) {
        return repositories.get(entityClass);
    }

    public Map<Class<?>, RepositoryDefinition> getAll() {
        return repositories;
    }
}