package com.dimitar.sfg.sfgpetclinic.model;

import lombok.Data;

@Data
public class Person extends BaseEntity {
    private String firstName;
    private String lastName;
}
