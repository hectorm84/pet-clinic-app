package guru.springframework.petclinicapp.bootstrap;

import guru.springframework.petclinicapp.model.*;
import guru.springframework.petclinicapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }

    }

    private void loadData() {
        // Owners declare
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        //Vets declare
        Vet vet1 = new Vet();
        Vet vet2 = new Vet();

        //Pet type declare
        PetType dog = new PetType();
        PetType cat = new PetType();
        PetType bird = new PetType();
        //Pet type initialization
        dog.setName("Dog");
        cat.setName("Cat");
        bird.setName("Guacamaya");
        //Pet type persistence
        PetType savedDogType =  petTypeService.save(dog);
        PetType savedCatType = petTypeService.save(cat);
        PetType savedBirdType = petTypeService.save(bird);

        //Speciality declare
        Speciality radiology = new Speciality();
        Speciality surgery = new Speciality();
        Speciality dentistry = new Speciality();
        //Speciality initialization
        radiology.setDescription("radiology");
        surgery.setDescription("surgery");
        dentistry.setDescription("dentistry");
        //Speciality persistence
        Speciality savedRadiology = specialityService.save(radiology);
        Speciality savedSurgery = specialityService.save(surgery);
        Speciality savedDentistry = specialityService.save(dentistry);


        owner1.setFirstName("Hector M");
        owner1.setLastName("Hernandez");
        owner1.setAddress("Caricuao");
        owner1.setCity("Caracas");
        owner1.setTelephone("4242047455");

        Pet hectorDog = new Pet();
        hectorDog.setPetType(savedDogType);
        hectorDog.setBirthDate(LocalDate.now());
        hectorDog.setName("London");
        hectorDog.setOwner(owner1);
        owner1.getPets().add(hectorDog);

        owner2.setFirstName("Jacqueline G");
        owner2.setLastName("Briceño");
        owner2.setAddress("Caricuao");
        owner2.setCity("Caracas");
        owner2.setTelephone("414785256");

        Pet jacCat = new Pet();
        jacCat.setPetType(savedCatType);
        jacCat.setBirthDate(LocalDate.now());
        jacCat.setName("misufu");
        jacCat.setOwner(owner2);
        owner2.getPets().add(jacCat);

        vet1.setFirstName("Hebert");
        vet1.setLastName("Hernandez");
        vet1.getSpecialities().add(savedRadiology);

        vet2.setFirstName("Mirta");
        vet2.setLastName("Fariñas");
        vet2.getSpecialities().add(savedDentistry);

        ownerService.save(owner1);
        ownerService.save(owner2);
        vetService.save(vet1);
        vetService.save(vet2);

        Visit visit1 = new Visit();
        visit1.setDate(LocalDate.now());
        visit1.setDescription("check cat health");
        visit1.setPet(jacCat);
        visitService.save(visit1);
    }
}
 