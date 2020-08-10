package guru.springframework.petclinicapp.bootstrap;

import guru.springframework.petclinicapp.model.Owner;
import guru.springframework.petclinicapp.model.Vet;
import guru.springframework.petclinicapp.services.OwnerService;
import guru.springframework.petclinicapp.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        Vet vet1 = new Vet();
        Vet vet2 = new Vet();

        owner1.setFirstName("Hector M");
        owner1.setLastName("Hernandez");

        owner2.setFirstName("Jacqueline G");
        owner2.setLastName("Briceño");

        vet1.setFirstName("Hebert");
        vet1.setLastName("Hernandez");

        vet2.setFirstName("Mirta");
        vet2.setLastName("Fariñas");

        ownerService.save(owner1);
        ownerService.save(owner2);
        vetService.save(vet1);
        vetService.save(vet2);

    }
}
 