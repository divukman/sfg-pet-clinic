package com.dimitar.sfg.sfgpetclinic.services.springdatajpa;

import com.dimitar.sfg.sfgpetclinic.model.Owner;
import com.dimitar.sfg.sfgpetclinic.repositories.OwnerRepository;
import com.dimitar.sfg.sfgpetclinic.repositories.PetRepository;
import com.dimitar.sfg.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LASTNAME_SMITH = "Smith";

    @Mock
    private OwnerRepository ownerRepository;

    @Mock
    private PetRepository petRepository;

    @Mock
    private PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findById() {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setLastName(LASTNAME_SMITH);


        when(ownerRepository.findById(1L)).thenReturn(Optional.of(owner));

        Owner smith = ownerSDJpaService.findById(1L);
        assertEquals(LASTNAME_SMITH, smith.getLastName());
    }


    @Test
    void findByLastName() {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setLastName(LASTNAME_SMITH);

        when(ownerRepository.findByLastName(any())).thenReturn(owner);

        Owner smith = ownerSDJpaService.findByLastName(LASTNAME_SMITH);
        assertEquals(LASTNAME_SMITH, smith.getLastName());
    }
}