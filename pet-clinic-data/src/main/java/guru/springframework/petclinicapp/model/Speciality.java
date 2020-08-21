package guru.springframework.petclinicapp.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Specialities")
public class Speciality extends BaseEntity{

    @Column(name = "description")
    private String description;

}
