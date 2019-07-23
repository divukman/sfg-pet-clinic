package com.dimitar.sfg.sfgpetclinic.services.map;

import com.dimitar.sfg.sfgpetclinic.model.Speciality;
import com.dimitar.sfg.sfgpetclinic.services.SpecialitiesService;
import org.springframework.stereotype.Service;

@Service
public class SpecialitieServicesMap extends AbstractMapService<Speciality, Long> implements SpecialitiesService {
}
