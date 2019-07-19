package com.dimitar.sfg.sfgpetclinic.bootstrap;

import com.dimitar.sfg.sfgpetclinic.model.Owner;
import com.dimitar.sfg.sfgpetclinic.model.Vet;
import com.dimitar.sfg.sfgpetclinic.services.OwnerService;
import com.dimitar.sfg.sfgpetclinic.services.VetService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Log
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(final OwnerService ownerService, final VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Mate");
        owner1.setLastName("Vukorepa");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Petar");
        owner2.setLastName("Peric");

        ownerService.save(owner2);

        log.info("Loading owners...");

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Marko");
        vet.setLastName("Zecic");

        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Deanna");
        vet2.setLastName("Rabbit");

        vetService.save(vet2);

        log.info("Loading vets...");
        log.info("Data loaded...");
    }

}
