package com.dimitar.sfg.sfgpetclinic.services.map;

import com.dimitar.sfg.sfgpetclinic.model.Owner;
import com.dimitar.sfg.sfgpetclinic.services.PetService;
import com.dimitar.sfg.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    PetTypeService petTypeService;
    PetService petService;

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setLastName("Antic");

        ownerMapService.save(owner);
    }

    @Test
    void save() {
        final Owner owner = new Owner();
        owner.setId(2L);
        owner.setLastName("Matic");

        ownerMapService.save(owner);
        assertNotNull(ownerMapService.findByLastName("Matic"));
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName("Antic");
        assertNotNull(owner);
    }
}