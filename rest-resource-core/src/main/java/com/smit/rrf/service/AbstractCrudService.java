package com.smit.rrf.service;

import com.smit.rrf.exception.ResourceNotFoundException;
import com.smit.rrf.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public abstract class AbstractCrudService<T, ID>
        implements RestResourceService<T, ID> {

    protected final BaseRepository<T, ID> repository;

    protected AbstractCrudService(BaseRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update(ID id, T entity) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Resource not found with id: " + id
            );
        }

        return repository.save(entity);
    }

    @Override
    public void delete(ID id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Resource not found with id: " + id
            );
        }

        repository.deleteById(id);
    }
}