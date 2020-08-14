package guru.springframework.petclinicapp.services.springdatajpa;

import guru.springframework.petclinicapp.model.Visit;
import guru.springframework.petclinicapp.repositories.VisitRepository;
import guru.springframework.petclinicapp.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDjpaService implements VisitService {

    private final VisitRepository visitRepository;

    @Autowired
    public VisitSDjpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long id) {
        Optional<Visit> visit = visitRepository.findById(id);
        if(visit.isPresent())
            return visit.get();
        return null;
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
