package com.dimitar.sfg.sfgpetclinic.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="types")
public class PetType extends BaseEntity<Long> {

    @Column(name="name")
    private String name;


}
