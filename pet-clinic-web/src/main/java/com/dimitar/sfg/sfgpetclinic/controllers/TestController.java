package com.dimitar.sfg.sfgpetclinic.controllers;

import com.dimitar.sfg.sfgpetclinic.model.Owner;
import com.dimitar.sfg.sfgpetclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final OwnerService ownerService;

    @Autowired
    public TestController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @GetMapping("/api/v1/test/testOwnerService")
    public ResponseEntity<?> testOwnerService() {
        Owner owner = new Owner();
        owner.setFirstName("Mate");
        owner.setLastName("Vukorepa");
        owner.setId(1L);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jure");
        owner2.setLastName("Vukorepa");
        owner2.setId(2L);

        ownerService.save(owner);
        ownerService.save(owner2);

        return new ResponseEntity<>(ownerService.findAll(), HttpStatus.OK);
    }
}
