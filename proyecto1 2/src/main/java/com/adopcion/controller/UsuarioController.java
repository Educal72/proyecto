
package com.adopcion.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
public class UsuarioController {
    @Autowired
    
    @GetMapping("/cuenta")
    public String cuenta(){
        return "cuenta";
    }

    
}
