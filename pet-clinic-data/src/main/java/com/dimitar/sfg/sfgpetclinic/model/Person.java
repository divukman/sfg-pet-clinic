package com.dimitar.sfg.sfgpetclinic.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class Person extends BaseEntity<Long> {

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;
}
