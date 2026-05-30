package com.smit.rrf.bootstrap.factory;

import com.smit.rrf.metadata.RepositoryDefinition;
import com.smit.rrf.repository.BaseRepository;
import org.springframework.core.ResolvableType;

public class RepositoryDefinitionFactory {

    public RepositoryDefinition create(
            Class<?> repositoryClass) {

        ResolvableType type =
                ResolvableType.forClass(repositoryClass)
                        .as(BaseRepository.class);

        Class<?> entityClass =
                type.getGeneric(0).resolve();

        return new RepositoryDefinition(
                entityClass,
                repositoryClass
        );
    }
}