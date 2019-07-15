package com.dimitar.sfg.sfgpetclinic.services;

public interface PersonService <T> {

    T findByLastName(String lastName);

}
