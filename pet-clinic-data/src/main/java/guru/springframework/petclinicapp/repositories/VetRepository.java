package guru.springframework.petclinicapp.repositories;

import guru.springframework.petclinicapp.model.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends CrudRepository<Vet, Long> {
}
