package guru.springframework.petclinicapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/vets")
public class VetController {

    @RequestMapping(value = {"","/","/index", "/index.html"}, method = RequestMethod.GET)
    public String listVets(){
        return "vets/index";
    }

}
