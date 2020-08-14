package guru.springframework.petclinicapp.services.springdatajpa;

import guru.springframework.petclinicapp.model.Speciality;
import guru.springframework.petclinicapp.repositories.SpecialityRepository;
import guru.springframework.petclinicapp.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtySDjpaService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    @Autowired
    public SpecialtySDjpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        Optional<Speciality> speciality = specialityRepository.findById(id);
        if(speciality.isPresent())
            return speciality.get();
        return null;
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        specialityRepository.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
