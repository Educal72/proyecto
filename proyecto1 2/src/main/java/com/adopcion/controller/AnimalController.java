
package com.adopcion.controller;


import com.adopcion.domain.Animal;
import com.adopcion.service.AnimalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class AnimalController {
    @Autowired
    private AnimalService animalService;
    
    @GetMapping("/adopcion/nuevo")
    public String animalNuevo(Animal animal){
        return "adopcionnuevo";
    }
    
    
    @PostMapping("/adopcion/guardar")
    public String animalGuardar(Animal animal){
        animalService.save(animal);
        return "redirect:/adopcion/ver";
    }
    
    @GetMapping("/adopcion/modificar/{idAnimal}")
    public String animalModificar(Animal animal, Model model){
        animal=animalService.getAnimal(animal);
        model.addAttribute("animal", animal);
        return "adopcionadmin";
    }
    
    @GetMapping("/adopcion/eliminar/{idAnimal}")
    public String animalEliminar(Animal animal){
        animalService.delete(animal);
        return "redirect:/adopcion/ver";
    }
    
    @GetMapping("/adopcion/ver")
    public String adopcionVer(Model model){
        var animales=animalService.getAnimales();
        model.addAttribute("animales", animales);
        return "adopcion";
    }
}
