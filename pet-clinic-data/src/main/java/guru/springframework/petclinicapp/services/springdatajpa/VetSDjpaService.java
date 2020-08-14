package guru.springframework.petclinicapp.services.springdatajpa;

import guru.springframework.petclinicapp.model.Vet;
import guru.springframework.petclinicapp.repositories.VetRepository;
import guru.springframework.petclinicapp.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDjpaService implements VetService {

    private final VetRepository vetRepository;

    @Autowired
    public VetSDjpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        Optional<Vet> vet = vetRepository.findById(id);
        if(vet.isPresent())
            return vet.get();
        return null;
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
