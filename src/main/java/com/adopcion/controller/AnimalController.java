
package com.adopcion.controller;


import com.adopcion.domain.Animal;
import com.adopcion.service.AnimalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class AnimalController {
    @Autowired
    private AnimalService animalService;
    
    @GetMapping("/adopcion/ver")
    public String adopcionVer(Model model){
        var animales=animalService.getAnimales();
        
        model.addAttribute("animales", animales);
        return "adopcion";
    }
}
