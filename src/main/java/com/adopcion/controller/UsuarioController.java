
package com.adopcion.controller;

import com.adopcion.service.UserService;
import com.adopcion.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class UsuarioController {
    @Autowired
    private UserService userService;
   
    
    

    @GetMapping("/cuenta/nuevo")
    public String userNuevo(User user){
        return "login";
    }
    
    
    @PostMapping("/cuenta/guardar")
    public String userGuardar(User user){
        String nombre;
        String password;
        nombre= user.getUsername();
        password=user.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        var clave = encoder.encode(password);
        user.setPassword(clave);
        userService.save(user);
        return "redirect:/login";
    }
    
    @GetMapping("/cuenta/modificar/{idUsuario}")
    public String userModificar(User user, Model model){
        user=userService.getUsers(user);
        model.addAttribute("users", user);
        return "cuenta";
    }
    
    @GetMapping("/cuenta/eliminar/{idUsuario}")
    public String userEliminar(User user){
        userService.delete(user);
        return "redirect:/cuenta/ver";
    }
    
    @GetMapping("/cuenta/ver")
    public String cuentaVer(Model model){
        var users=userService.getUsers();
        model.addAttribute("users", users);
        return "cuenta";
    }
    
}
