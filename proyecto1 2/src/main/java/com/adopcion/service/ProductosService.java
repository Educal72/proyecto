
package com.adopcion.service;

import com.adopcion.domain.Productos;
import java.util.List;

public interface ProductosService {
    
    public List<Productos> getProductos(boolean activos);

    public Productos getProductos(Productos productos);
    
    public void save(Productos productos);
     
    public void delete(Productos productos);
    
    public List<Productos> findByCategoria (String categoria, boolean activos);
}
