package com.bluebottle.racehorse.service;

import org.springframework.data.domain.Pageable;

public interface IService<T> {
    Iterable<T> findAll(Pageable pageable);
    T findById(Long id);
    Boolean remove(Long id);
    T save(T t);
}
