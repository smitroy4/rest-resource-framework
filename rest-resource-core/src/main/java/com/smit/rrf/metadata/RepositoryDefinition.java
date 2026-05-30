package com.smit.rrf.metadata;

public class RepositoryDefinition {

    private final Class<?> entityClass;
    private final Class<?> repositoryClass;

    public RepositoryDefinition(
            Class<?> entityClass,
            Class<?> repositoryClass) {

        this.entityClass = entityClass;
        this.repositoryClass = repositoryClass;
    }

    public Class<?> getEntityClass() {
        return entityClass;
    }

    public Class<?> getRepositoryClass() {
        return repositoryClass;
    }
}