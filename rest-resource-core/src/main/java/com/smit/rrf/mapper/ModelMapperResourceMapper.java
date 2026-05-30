package com.smit.rrf.mapper;

import org.modelmapper.ModelMapper;

public class ModelMapperResourceMapper implements ResourceMapper {

    private final ModelMapper modelMapper;

    public ModelMapperResourceMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public <D, E> D toDto(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    @Override
    public <D, E> E toEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }
}