package com.dimitar.sfg.sfgpetclinic.services;

import java.util.Set;

public interface BaseService <T> {

    T findById(Long id);

    T save(T object);

    Set<T> findAll();
}
