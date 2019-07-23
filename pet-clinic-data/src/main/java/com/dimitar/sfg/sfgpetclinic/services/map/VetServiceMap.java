package com.dimitar.sfg.sfgpetclinic.services.map;

import com.dimitar.sfg.sfgpetclinic.model.Vet;
import com.dimitar.sfg.sfgpetclinic.services.SpecialitiesService;
import com.dimitar.sfg.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialitiesService specialitiesService;

    @Autowired
    public VetServiceMap(SpecialitiesService specialitiesService) {
        this.specialitiesService = specialitiesService;
    }

    @Override
    public Vet findByLastName(String lastName) {
        return this.map.values().stream().filter(owner -> owner.getLastName().equalsIgnoreCase(lastName)).findFirst().orElse(null);
    }


    @Override
    public Vet save(Vet object) {

        if (object != null) {

            if (object.getSpecialities().size() > 0) {
                object.getSpecialities().forEach(speciality -> {
                    if (speciality.getId() == null) {
                        specialitiesService.save(speciality);
                    }
                });
            }

            return super.save(object);
        } else {
            return null;
        }
    }

}
