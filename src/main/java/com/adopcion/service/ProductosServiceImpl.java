
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
    public List<Productos> getProductos() {
        return (List<Productos>)productoDao.findAll();
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
}
