package com.adopcion.controller;

import com.adopcion.domain.Productos;
import com.adopcion.service.ProductosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ProductosController {
    
    @Autowired
    private ProductosService productosService;
    
    @GetMapping("/productos/nuevo")
    public String productosNuevo(Productos productos){
        return "productosnuevo";
    }
    
    @PostMapping("/productos/guardar")
    public String productosGuardar(Productos productos){
        productosService.save(productos);
        return "redirect:/productos/ver";
    }
    
    @GetMapping("/productos/modificar/{idProducto}")
    public String productosModificar(Productos productos, Model model){
        productos=productosService.getProductos(productos);
        model.addAttribute("productos", productos);
        return "productosadmin";
    }
    
    @GetMapping("/productos/eliminar/{idProducto}")
    public String productosEliminar(Productos productos){
        productosService.delete(productos);
        return "redirect:/productos/ver";
    }
    
    @GetMapping("/productos/ver")
    public String productosVer(Model model){
        var productos=productosService.getProductos(true);
        model.addAttribute("productos", productos);
        return "productos";
    }
    
    @GetMapping("/productos/buscar/alimento")
    public String productosAlimentos(Model model, String categoria){
        var categorias = productosService.findByCategoria("Alimento",true);
        model.addAttribute("productos", categorias);
        return "productos";
    }
    
    @GetMapping("/productos/buscar/correas")
    public String productosCorreas(Model model, String categoria){
        var categorias = productosService.findByCategoria("Correas",true);
        model.addAttribute("productos", categorias);
        return "productos";
    }
    
    @GetMapping("/productos/buscar/juguetes")
    public String productosJuguetes(Model model, String categoria){
        var categorias = productosService.findByCategoria("Juguetes",true);
        model.addAttribute("productos", categorias);
        return "productos";
    }
    
    @GetMapping("/productos/buscar/higiene")
    public String productosHigiene(Model model, String categoria){
        var categorias = productosService.findByCategoria("Higiene",true);
        model.addAttribute("productos", categorias);
        return "productos";
    }
}
