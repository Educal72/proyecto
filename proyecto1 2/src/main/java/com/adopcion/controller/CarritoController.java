
package com.adopcion.controller;

import com.adopcion.service.AnimalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class CarritoController {
    
    
    @GetMapping("/carrito/ver")
    public String carritoVer(Model model){
        return "carrito";
    }
}
