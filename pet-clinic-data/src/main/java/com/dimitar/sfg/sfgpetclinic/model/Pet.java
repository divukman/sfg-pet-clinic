package com.dimitar.sfg.sfgpetclinic.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Pet extends BaseEntity<Long> {
    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;
}
