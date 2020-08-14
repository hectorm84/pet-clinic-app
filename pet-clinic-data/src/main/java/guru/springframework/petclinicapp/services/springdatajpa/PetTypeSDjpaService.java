package guru.springframework.petclinicapp.services.springdatajpa;

import guru.springframework.petclinicapp.model.PetType;
import guru.springframework.petclinicapp.repositories.PetTypeRepository;
import guru.springframework.petclinicapp.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDjpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    @Autowired
    public PetTypeSDjpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long id) {
        Optional<PetType> petType = petTypeRepository.findById(id);
        if(petType.isPresent())
            return petType.get();
        return null;
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
