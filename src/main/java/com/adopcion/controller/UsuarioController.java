
package com.adopcion.controller;

import com.adopcion.domain.Usuarios;
import com.adopcion.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping("/usuarios/nuevo")
    public String usuariosNuevo(Usuarios usuarios){
        return "usuariosnuevo";
    }
    
    @PostMapping("/usuarios/guardar")
    public String usuariosGuardar(Usuarios usuarios){
        usuarioService.save(usuarios);
        return "redirect:/usuarios/ver";
    }
    
    @GetMapping("/productos/modificar/{idUsuarios}")
    public String usuariosModificar(Usuarios usuarios, Model model){
        usuarios=usuarioService.getUsuarios(usuarios);
        model.addAttribute("usuarios", usuarios);
        return "usuariosadmin";
    }
    
    @GetMapping("/usuarios/eliminar/{idUsuario}")
    public String usuariosEliminar(Usuarios usuarios){
        usuarioService.delete(usuarios);
        return "redirect:/usuarios/ver";
    }
    
    @GetMapping("/usuarios/ver")
    public String productosVer(Model model){
        var usuarios=usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }
    
}
