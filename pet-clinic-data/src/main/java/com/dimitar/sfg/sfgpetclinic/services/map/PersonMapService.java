package com.dimitar.sfg.sfgpetclinic.services.map;

import com.dimitar.sfg.sfgpetclinic.model.Person;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @deprecated I think I just created this by an error. I see no reason to use it for now.
 * @todo delete later
 */
@Service
@Profile({"default", "map"})
@Deprecated
public class PersonMapService extends AbstractMapService<Person, Long> {
}
