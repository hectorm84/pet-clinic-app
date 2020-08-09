 package guru.springframework.petclinicapp.services;

import guru.springframework.petclinicapp.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
