/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParteProyectoWeb.proyectowebDA.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


/**
 *
 * @author DYL4N16199
 */
@Data
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    String nombre;
    String apellidos;
    String correo;
    String telefono;
    String direccion;
    int puntos;
    int calificacion;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String nombre, String apellidos, String correo, String telefono, String direccion, int puntos, int calificacion) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.puntos = puntos;
        this.calificacion = calificacion;
    }
    
    

    
    
}
