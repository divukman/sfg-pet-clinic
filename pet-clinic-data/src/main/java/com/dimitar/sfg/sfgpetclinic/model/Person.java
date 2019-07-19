package com.dimitar.sfg.sfgpetclinic.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
public class Person extends BaseEntity<Long> {
    private String firstName;
    private String lastName;
}
