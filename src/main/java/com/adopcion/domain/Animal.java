/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adopcion.domain;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Image;
import java.io.Serializable;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Type;

@Data
@Entity
@Table(name="animales")
public class Animal implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnimal;
    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    byte[] img;
    String nombre;
    int edad;
    String raza;
    String descripcion;
    
    @Column(name="ruta_imagen")
    String rutaImagen;
    

    public Animal() {
    }

    public Animal(Long idAnimal, byte[] img, String nombre, int edad, String raza, String descripcion,String rutaImagen) {
        this.idAnimal = idAnimal;
        this.img = img;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
    }
    

}
