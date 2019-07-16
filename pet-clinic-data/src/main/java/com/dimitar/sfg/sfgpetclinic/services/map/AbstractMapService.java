package com.dimitar.sfg.sfgpetclinic.services.map;


import com.dimitar.sfg.sfgpetclinic.model.BaseEntity;
import com.dimitar.sfg.sfgpetclinic.services.CrudService;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity<ID>, ID>
        implements CrudService<T, ID> {

    protected Map<ID, T> map = new HashMap<>();


    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T findById(ID id) {
        return map.get(id);
    }

    public T save(T object) {
        map.put(object.getId(), object);
        return object;
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    public void delete(T object) {
        map.entrySet().removeIf( entry -> entry.getValue().equals(object));
    }
}
