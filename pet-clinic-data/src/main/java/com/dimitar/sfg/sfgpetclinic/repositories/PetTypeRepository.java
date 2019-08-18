package com.dimitar.sfg.sfgpetclinic.repositories;

import com.dimitar.sfg.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
