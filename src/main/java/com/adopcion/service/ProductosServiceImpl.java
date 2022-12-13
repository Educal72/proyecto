
package com.adopcion.service;

import com.adopcion.dao.ProductosDao;
import com.adopcion.domain.Productos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductosServiceImpl implements ProductosService{
    
    @Autowired
    private ProductosDao productoDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Productos> getProductos(boolean activos) {
        var lista = (List<Productos>)productoDao.findAll();
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public Productos getProductos(Productos productos) {
        return productoDao.findById(productos.getIdProducto()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Productos productos) {
        productoDao.save(productos);

    }

    @Override
    @Transactional
    public void delete(Productos productos) {
        productoDao.delete(productos);

    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Productos> findByCategoria(String categoria, boolean activos){
       var lista = (List<Productos>)productoDao.findByCategoria(categoria);
        if(activos){
            lista.removeIf(e -> !e.isActivo());
            
        }
        return lista;
    }
}
