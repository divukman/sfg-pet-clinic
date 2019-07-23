package com.dimitar.sfg.sfgpetclinic.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Speciality extends BaseEntity<Long> {
    private String description;
}
