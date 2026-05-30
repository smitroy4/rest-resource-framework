package com.smit.rrf.bootstrap.factory;

import com.smit.rrf.annotations.RestResource;
import com.smit.rrf.metadata.ResourceDefinition;

public class ResourceDefinitionFactory {

    public ResourceDefinition create(Class<?> clazz) {

        RestResource annotation =
                clazz.getAnnotation(RestResource.class);

        ResourceDefinition definition =
                new ResourceDefinition();

        definition.setEntityClass(clazz);
        definition.setDtoClass(annotation.dto());
        definition.setPath(annotation.path());
        definition.setPageable(annotation.pageable());
        definition.setSortable(annotation.sortable());
        definition.setSearchable(annotation.searchable());

        return definition;
    }
}