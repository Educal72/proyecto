/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adopcion.domain;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="usuario")
public class User implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Long idUsuario;
    String username;
    String password;
    
    
    @OneToMany
    @JoinColumn(name="id_usuario")
    private List<Rol> roles;
    
    

    public User() {
    }

    public User(Long idUsuario, String username, String password) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
    }

    

    
    
}
