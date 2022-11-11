/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.adopcion.dao;

import com.adopcion.domain.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Educal
 */
public interface ProductosDao extends JpaRepository<Productos, Long>{
    
}
