/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adopcion.domain;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="productos")
public class Productos implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    String categoria;
    String nombre;
    int precio;
    String descripcion;
    int existencias;
    boolean activo;

    public Productos() {
    }

    public Productos(Long idProducto, String categoria, String nombre, int precio, String descripcion, int existencias, boolean activo) {
        this.idProducto = idProducto;
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.existencias = existencias;
        this.activo = activo;
    }

    
    
}
