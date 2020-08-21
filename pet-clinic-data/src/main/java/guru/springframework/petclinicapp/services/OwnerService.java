 package guru.springframework.petclinicapp.services;

import guru.springframework.petclinicapp.model.Owner;

import java.util.List;

 public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);


}
