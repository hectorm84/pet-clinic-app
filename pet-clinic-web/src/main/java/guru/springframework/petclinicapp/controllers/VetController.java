package guru.springframework.petclinicapp.controllers;

import guru.springframework.petclinicapp.model.Vet;
import guru.springframework.petclinicapp.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@Controller
@RequestMapping("/vets")
public class VetController {

    VetService vetService;

    @Autowired
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping(value = {"","/","/index", "/index.html"}, method = RequestMethod.GET)
    public String listVets(Model model){
        Set<Vet> vets = vetService.findAll();
        model.addAttribute("vets", vets);
        return "vets/index";
    }

}
