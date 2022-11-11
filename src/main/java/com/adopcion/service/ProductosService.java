
package com.adopcion.service;

import com.adopcion.domain.Productos;
import java.util.List;

public interface ProductosService {
    
    public List<Productos> getProductos();

    public Productos getProductos(Productos productos);
    
    public void save(Productos productos);
     
    public void delete(Productos productos);
}
