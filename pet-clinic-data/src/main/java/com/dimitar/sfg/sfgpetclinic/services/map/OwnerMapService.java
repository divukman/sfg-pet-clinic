package com.dimitar.sfg.sfgpetclinic.services.map;

import com.dimitar.sfg.sfgpetclinic.model.Owner;
import com.dimitar.sfg.sfgpetclinic.model.Pet;
import com.dimitar.sfg.sfgpetclinic.services.OwnerService;
import com.dimitar.sfg.sfgpetclinic.services.PetService;
import com.dimitar.sfg.sfgpetclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class OwnerMapService
        extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    @Autowired
    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }


    @Override
    public Owner save(Owner object) {
        if (object != null) {

            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required!");
                    }

                    if (pet.getId() == null) {
                        final Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId()); //!?!
                    }
                });
            }

            return super.save(object);
        } else {
            return null;
        }
    }


    @Override
    public Owner findByLastName(String lastName) {
        return this.map.values().stream().filter(owner -> owner.getLastName().equalsIgnoreCase(lastName)).findFirst().orElse(null);
    }
}
