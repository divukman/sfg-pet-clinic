package com.dimitar.sfg.sfgpetclinic.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEntity<ID> implements Serializable {
    private ID id;

    public boolean isNew() {
        return this.id == null;
    }

}
