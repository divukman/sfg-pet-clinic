package com.dimitar.sfg.sfgpetclinic.services.map;

import com.dimitar.sfg.sfgpetclinic.model.Pet;
import com.dimitar.sfg.sfgpetclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
}
