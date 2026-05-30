package com.smit.rrf.mapper;

public interface ResourceMapper {

    <D, E> D toDto(E entity, Class<D> dtoClass);

    <D, E> E toEntity(D dto, Class<E> entityClass);
}