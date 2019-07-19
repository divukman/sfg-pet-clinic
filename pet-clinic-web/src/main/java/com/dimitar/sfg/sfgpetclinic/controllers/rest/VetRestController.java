package com.dimitar.sfg.sfgpetclinic.controllers.rest;

import com.dimitar.sfg.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vet")
public class VetRestController {

    private final VetService vetService;

    @Autowired
    public VetRestController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<?> getVets() {
        return new ResponseEntity<>(vetService.findAll(), HttpStatus.OK);
    }
}
