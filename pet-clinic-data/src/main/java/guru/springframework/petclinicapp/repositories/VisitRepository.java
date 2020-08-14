package guru.springframework.petclinicapp.repositories;

import guru.springframework.petclinicapp.model.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
