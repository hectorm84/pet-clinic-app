package guru.springframework.petclinicapp.formatters;

import guru.springframework.petclinicapp.model.PetType;
import guru.springframework.petclinicapp.services.PetService;
import guru.springframework.petclinicapp.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;
import org.springframework.format.Formatter;

@Component
public class PetTypeFormatter implements Formatter<PetType>{

    private final PetTypeService petService;

    @Autowired
    public PetTypeFormatter(PetTypeService petService) {
        this.petService = petService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = this.petService.findAll();
        for (PetType type : findPetTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }
        throw new ParseException("type not found: " + text, 0);
    }
}
