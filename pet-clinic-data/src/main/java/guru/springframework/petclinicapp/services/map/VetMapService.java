package guru.springframework.petclinicapp.services.map;

import guru.springframework.petclinicapp.model.Vet;
import guru.springframework.petclinicapp.services.CrudService;

import java.util.Set;

public class VetMapService extends AbstracMapService<Vet, Long> implements CrudService<Vet, Long> {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object, object.getId());
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
