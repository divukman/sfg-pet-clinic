package com.dimitar.sfg.sfgpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="specialities")
public class Speciality extends BaseEntity<Long> {

    @Column(name="description")
    private String description;


}
