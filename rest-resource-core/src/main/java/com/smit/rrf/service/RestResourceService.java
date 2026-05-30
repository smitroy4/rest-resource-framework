package com.smit.rrf.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RestResourceService<T, ID> {

    Page<T> findAll(Pageable pageable);

    Optional<T> findById(ID id);

    T save(T entity);

    T update(ID id, T entity);

    void delete(ID id);
}