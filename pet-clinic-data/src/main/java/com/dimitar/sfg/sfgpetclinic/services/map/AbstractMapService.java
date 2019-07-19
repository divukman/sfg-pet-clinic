package com.dimitar.sfg.sfgpetclinic.services.map;


import com.dimitar.sfg.sfgpetclinic.model.BaseEntity;
import com.dimitar.sfg.sfgpetclinic.services.CrudService;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity<Long>, ID extends Long>
        implements CrudService<T, ID> {

    protected Map<Long, T> map = new HashMap<>();


    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T findById(ID id) {
        return map.get(id);
    }

    public T save(T object) {
        if (object != null) {
            Long id = object.getId() != null ? object.getId() : getNextId();
            map.put(id, object);
        } else {
            throw new RuntimeException("Object cannot be null!");
        }
        return object;
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    public void delete(T object) {
        map.entrySet().removeIf( entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        final Long id = map.keySet().size() > 0 ?  Collections.max(map.keySet()) + 1: 1L;
        return id;
    }
}
