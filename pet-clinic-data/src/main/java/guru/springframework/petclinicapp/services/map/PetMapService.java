package guru.springframework.petclinicapp.services.map;

import guru.springframework.petclinicapp.model.Pet;
import guru.springframework.petclinicapp.services.CrudService;

import java.util.Set;

public class PetMapService extends AbstracMapService<Pet, Long> implements CrudService<Pet, Long> {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object, object.getId());
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
