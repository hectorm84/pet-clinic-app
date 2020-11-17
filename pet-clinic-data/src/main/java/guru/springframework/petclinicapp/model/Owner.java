package guru.springframework.petclinicapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Column(name = "address")
    private String address;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Pet> pets = new HashSet<>();


    public Owner addPet(Pet pet){
        pet.setOwner(this);
        this.getPets().add(pet);
        return this;
    }

    /**
     * Return the Pet with the given name, or null if none found for this Owner.
     * @param name to test
     * @return true if pet name is already in use
     */
    public Pet getPet(String name) {
        return getPet(name, false);
    }

    /**
     * Return the Pet with the given name, or null if none found for this Owner.
     * @param name to test
     * @return true if pet name is already in use
     */
    public Pet getPet(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Pet pet : pets) {
            if (!ignoreNew || !pet.isNew()) {
                String compName = pet.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return pet;
                }
            }
        }
        return null;
    }
}
