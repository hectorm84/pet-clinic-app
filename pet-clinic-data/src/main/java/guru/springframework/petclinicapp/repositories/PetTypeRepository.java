package guru.springframework.petclinicapp.repositories;

import guru.springframework.petclinicapp.model.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
