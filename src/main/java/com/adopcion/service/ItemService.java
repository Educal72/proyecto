
package com.adopcion.service;

import com.adopcion.domain.Item;
import java.util.ArrayList;
import java.util.List;

public interface ItemService {
    
    
    public List<Item> listaItems= new ArrayList<>();
    
    
    public List<Item> getItems();

    public Item getItem(Item item);
    
    public void save(Item item);
     
    public void delete(Item item);
    
   
    
    public void actualizar(Item item);
    
    public void facturar();
    
}
