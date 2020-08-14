package guru.springframework.petclinicapp.services.springdatajpa;

import guru.springframework.petclinicapp.model.Pet;
import guru.springframework.petclinicapp.model.Vet;
import guru.springframework.petclinicapp.repositories.PetRepository;
import guru.springframework.petclinicapp.repositories.VetRepository;
import guru.springframework.petclinicapp.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDjpaService implements PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetSDjpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        Optional<Pet> pet = petRepository.findById(id);
        if(pet.isPresent())
            return pet.get();
        return null;
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
