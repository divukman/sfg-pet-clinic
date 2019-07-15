package com.dimitar.sfg.sfgpetclinic.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEntity implements Serializable {
    private Long id;

    public boolean isNew() {
        return this.id == null;
    }

}
