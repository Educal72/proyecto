
package com.adopcion.domain;

import lombok.Data;

/**
 *
 * @author DYL4N16199
 */
@Data
public class Item extends Productos{
    private int cantidad; // esto almacena la cantidad de items de un producto especifico 

    public Item() {
    }

    public Item(Productos productos) {        
        super.setIdProducto(productos.getIdProducto());
        super.setCategoria(productos.getCategoria());
        super.setNombre(productos.nombre);
        super.setPrecio(productos.getPrecio());
        super.setDescripcion(productos.getDescripcion());
        super.setExistencias(productos.getExistencias());
        super.setActivo(productos.isActivo());
        this.cantidad = 0;
    }
    
    
    
}
