package guru.springframework.petclinicapp.services.map;

import guru.springframework.petclinicapp.model.Owner;
import guru.springframework.petclinicapp.services.PetService;
import guru.springframework.petclinicapp.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    @Mock
    PetService petService;
    @Mock
    PetTypeService petTypeService;
    OwnerMapService ownerMapService;
    private final Long ownerId = 1L;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(petTypeService, petService);
        Owner o = new Owner();
        o.setId(ownerId);
        o.setCity("caracas");
        o.setAddress("caricuao");
        ownerMapService.save(o);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void save() {
        Owner owner = new Owner();
        owner.setId(ownerId);
        owner.setCity("Caracas");
        Owner savedOwner = ownerMapService.save(owner);
        assertEquals(ownerId, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner owner = new Owner();
        owner.setCity("Caracas");
        Owner savedOwner = ownerMapService.save(owner);
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = new Owner();
        owner.setLastName("hernandez");
        Owner savedOwner =ownerMapService.save(owner);
        assertEquals("hernandez", ownerMapService.findById(savedOwner.getId()).getLastName());
    }
}