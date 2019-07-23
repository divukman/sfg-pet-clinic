package com.dimitar.sfg.sfgpetclinic.bootstrap;

import com.dimitar.sfg.sfgpetclinic.model.*;
import com.dimitar.sfg.sfgpetclinic.services.OwnerService;
import com.dimitar.sfg.sfgpetclinic.services.PetTypeService;
import com.dimitar.sfg.sfgpetclinic.services.SpecialitiesService;
import com.dimitar.sfg.sfgpetclinic.services.VetService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Log
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;

    @Autowired
    public DataLoader(final OwnerService ownerService, final VetService vetService, final PetTypeService petTypeService, final SpecialitiesService specialitiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (petTypeService.findAll().size() == 0) {
            loadData();
        }

    }

    private void loadData() {
        final PetType dog = new PetType();
        dog.setName("Dog");

        final PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        final PetType savedCatType = petTypeService.save(cat);

        PetType parrot = new PetType();
        final PetType savedParrotType = petTypeService.save(parrot);


        Owner owner1 = new Owner();
        owner1.setFirstName("Mate");
        owner1.setLastName("Vukorepa");
        owner1.setAddress("Vukorepe Gornje 10");
        owner1.setCity("Vukorepe Grad");
        owner1.setTelephone("099929292929");

        ownerService.save(owner1);

        Pet pet1 = new Pet();
        pet1.setPetType(savedDogType);
        pet1.setOwner(owner1);
        pet1.setName("Cuko");
        pet1.setBirthDate(LocalDate.now());
        owner1.getPets().add(pet1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Petar");
        owner2.setLastName("Peric");
        owner2.setAddress("Perici Gornji 1");
        owner2.setCity("Peric");
        owner2.setTelephone("09838383838");

        ownerService.save(owner2);

        Pet pet2 = new Pet();
        pet2.setPetType(savedCatType);
        pet2.setOwner(owner2);
        pet2.setName("Maca");
        pet2.setBirthDate(LocalDate.now());
        owner2.getPets().add(pet2);

        log.info("Loading owners...");


        ////////////////////////////////////////////////////
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        specialitiesService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        specialitiesService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        specialitiesService.save(dentistry);
        ////////////////////////////////////////////////////

        Vet vet = new Vet();
        vet.setFirstName("Marko");
        vet.setLastName("Zecic");
        vet.getSpecialities().add(radiology);

        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setFirstName("Deanna");
        vet2.setLastName("Rabbit");
        vet2.getSpecialities().add(dentistry);
        vet2.getSpecialities().add(surgery);

        vetService.save(vet2);

        log.info("Loading vets...");
        log.info("Data loaded...");
    }

}
