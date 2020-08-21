package guru.springframework.petclinicapp.services.springdatajpa;

import guru.springframework.petclinicapp.model.Owner;
import guru.springframework.petclinicapp.model.PetType;
import guru.springframework.petclinicapp.repositories.OwnerRepository;
import guru.springframework.petclinicapp.repositories.PetRepository;
import guru.springframework.petclinicapp.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDjpaServiceTest {

    private final  Long ownerId = 1L;
    private final String lastName = "hernandez";

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDjpaService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
       // ownerSDjpaService = new OwnerSDjpaService(ownerRepository, petRepository, petTypeRepository);
        Owner owner = new Owner();
        owner.setId(ownerId);
        owner.setLastName(lastName);
        service.save(owner);
    }



    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}