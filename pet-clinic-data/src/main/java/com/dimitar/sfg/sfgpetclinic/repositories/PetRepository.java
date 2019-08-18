package com.dimitar.sfg.sfgpetclinic.repositories;

import com.dimitar.sfg.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
