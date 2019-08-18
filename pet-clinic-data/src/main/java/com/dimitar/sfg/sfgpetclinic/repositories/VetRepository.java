package com.dimitar.sfg.sfgpetclinic.repositories;

import com.dimitar.sfg.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {

    public Vet findByLastName(String lastName);
}
