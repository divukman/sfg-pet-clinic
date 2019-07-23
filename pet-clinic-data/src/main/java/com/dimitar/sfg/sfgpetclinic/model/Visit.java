package com.dimitar.sfg.sfgpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Visit extends BaseEntity<Long> {

    private LocalDate date;
    private String description;
    private Pet pet;

}
