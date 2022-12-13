
package com.adopcion.controller;


import com.adopcion.domain.Item;
import com.adopcion.domain.Productos;
import com.adopcion.service.ItemService;
import com.adopcion.service.ProductosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@Slf4j
public class CarritoController {
    
   
    @Autowired
    private ItemService itemService;
    @Autowired
    private ProductosService productosService;
    
    // Para ver el carrito
    @GetMapping("/carrito/listado")
    public String inicio(Model model){
        var items = itemService.getItems();
        model.addAttribute("items",items);
        var carritoTotalVenta= 0;
        for ( Item i: items){
            carritoTotalVenta += (i.getCantidad() *i.getPrecio());            
        }
        model.addAttribute("carritoTotal",carritoTotalVenta);
        System.out.println(items);
        return "/carrito/listado";
         
    }
    // Agregar un producto al carrito
    @GetMapping("/carrito/agregar/{idProducto}")
    public ModelAndView agregarProducto(Model model, Item item){
        Item item2 = itemService.getItem(item);
        if( item2==null){
            Productos productos =productosService.getProductos(item);
            item2 = new Item(productos);
        }
        itemService.save(item2);
        var lista=itemService.getItems();
        var totalCarritos=0;
        var carritoTotalVenta=0;
        for(Item i:lista) {
            totalCarritos+=i.getCantidad();
            carritoTotalVenta +=(i.getCantidad()*i.getPrecio());            
        }
        model.addAttribute("listaItems",lista);
        model.addAttribute("listaTotal",totalCarritos);
        model.addAttribute("carritoTotal",carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentosCarrito :: verCarrito");                
    }
    
    // Para modificar un producto del carrito
    
    @GetMapping("/carrito/modificar/{idProducto}")
    public String modificarCarrito(Item item,Model model){
        item= itemService.getItem(item);
        model.addAttribute("item",item);
        return "/carrito/modificar";
    }
    
    //Para eliminar un producto del carrito
    @GetMapping("/carrito/eliminar/{idProducto}")
    public String eliminarItem(Item item) {
        itemService.delete(item);
        return "redirect:/carrito/listado";
        
    }
    
    //Para actualizar un producto del carrito en cuanto a la cantidad
    
    @PostMapping("/carrito/guardar")
    public String guardarItem(Item item){
        itemService.actualizar(item);
        return "redirect:/carrito/listado";
    }
    
    //Para facturar los productos del carrito... no esta implementado solo limpia el carrito
    @GetMapping("/facturar/carrito")
    public String facturarCarrito(){
        itemService.facturar();
        return "redirect:/";
    }
    
}
