package com.dimitar.sfg.sfgpetclinic.model;

import lombok.Data;

@Data
public class PetType extends BaseEntity<Long> {
    private String name;
}
