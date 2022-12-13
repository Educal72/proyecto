/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adopcion.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
    @Column(name="id_usuario")
    private Long idUsuario;
    
    @NotEmpty
    String username;
    
    @NotEmpty
    String password;
    
    @OneToMany
    @JoinColumn(name="id_usuario")
    private List<Rol> roles;
    
}

