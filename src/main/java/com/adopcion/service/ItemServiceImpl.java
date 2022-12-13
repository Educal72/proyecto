
package com.adopcion.service;

import com.adopcion.domain.Item;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;



@Service
public class ItemServiceImpl implements ItemService{
    
    

    @Override
    public List<Item> getItems() {
       return listaItems;
    }

    @Override
    public Item getItem(Item item) {
        for (Item c: listaItems){
            if (Objects.equals(c.getIdProducto(), item.getIdProducto())){
                return c;   
            }
        }
        return null;
        
        
    }

    @Override
    public void save(Item item) {
        boolean existe = false;
        for(Item c: listaItems){//Busca si el producto ya existe en el carrito
            
            if(Objects.equals(c.getIdProducto(),item.getIdProducto())){//verifica si se puede añadir un item adicional segun las existencias 
                if(c.getCantidad()< item.getExistencias()){//Incrementa en 1 la cantidad de elementos 
                    c.setCantidad(c.getCantidad()+1);
                }
                existe=true;
                break;
            }            
        }
        if(!existe){// Si el producto no existe en el carrito lo agrega con la cantidad de 1
            item.setCantidad(1);
            listaItems.add(item);
            
        }
    }

    @Override
    public void delete(Item item) {
        var posicion= -1;
        var existe= false;
        for(Item c: listaItems){
            ++posicion;
            if (Objects.equals(c.getIdProducto(), item.getIdProducto())){
                existe= true;
                break;
                
            }
        }
        if(existe){
            listaItems.remove(posicion);
            
        }
    }

    

    @Override
    public void actualizar(Item item) {
        for(Item i : listaItems){
            if(Objects.equals(i.getIdProducto(), item.getIdProducto())){
                i.setCantidad(item.getCantidad());
                break;
                
            }
        }
        
    }
    
//Este es un metodo que solo lo usamos para limpiar el carrito, pero aqui va la parte de facturacion
    @Override
    public void facturar() {
        for(Item i: listaItems){
            //aqui pondriamos los procesos
            
            
            
        }
        listaItems.clear();
        //Limpiamos la lista
        
    }
    
}
