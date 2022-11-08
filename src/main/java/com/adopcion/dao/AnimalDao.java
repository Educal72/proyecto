/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adopcion.dao;

import com.adopcion.domain.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Educal
 */
public interface AnimalDao extends JpaRepository<Animal, Long>{
    
}
