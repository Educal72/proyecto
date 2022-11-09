package ParteProyectoWeb.proyectowebDA.controller;

import ParteProyectoWeb.proyectowebDA.dao.UsuarioDao;
import ParteProyectoWeb.proyectowebDA.demo.domain.Usuario;
import ParteProyectoWeb.proyectowebDA.demo.service.UsuarioService;
import ParteProyectoWeb.proyectowebDA.service.UsuarioService;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


/**
 *
 * @author DYL4N16199
 */
@Controller
@Slf4j

public class UsuarioController {    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/usuario/nuevo")
    public String nuevoUsuario(Usuario usuario){                        
        return "modificarUsuario";
        
    }
    
    @PostMapping("/usuario/guardar")
    public String guardarUsuario(Usuario usuario){                        
        usuarioService.save(usuario);
        return "redirect:/";
        
    }
    
    @GetMapping("/usuario/modificar/{idUsuario}")
    public String usuarioModificar(Usuario usuario, Model model){    
        usuario= usuarioService.getUsuario (usuario);
        
        model.addAttribute("usuario",usuario);
        return "modificarUsuario";
        
    }
    @GetMapping("/usuario/eliminar/{idUsuario}")
    public String usuarioEliminar(Usuario usuario){    
        usuarioService.delete(usuario);
        
        return "redirect:/";
        
    }
    
    
    
}
