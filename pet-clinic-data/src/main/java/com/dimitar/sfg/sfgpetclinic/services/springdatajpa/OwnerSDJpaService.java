package com.dimitar.sfg.sfgpetclinic.services.springdatajpa;

import com.dimitar.sfg.sfgpetclinic.model.Owner;
import com.dimitar.sfg.sfgpetclinic.repositories.OwnerRepository;
import com.dimitar.sfg.sfgpetclinic.repositories.PetRepository;
import com.dimitar.sfg.sfgpetclinic.repositories.PetTypeRepository;
import com.dimitar.sfg.sfgpetclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    @Autowired
    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
                             PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findById(Long aLong) {
        return  ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Owner> findAll() {
        final Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach( owners::add );
        return owners;
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {

    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
