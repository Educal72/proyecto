/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adopcion;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author DYL4N16199
 */
public class Encriptar {
    public static void main(String[] args) {
       BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        var claveEduardo = encoder.encode("123");
        var claveDylan = encoder.encode("456");
        var claveCliente = encoder.encode("012");
        System.out.println("Eduardo (123): "+claveEduardo);
        System.out.println("Dylan (456): "+claveDylan);
        System.out.println("Cliente (012): "+claveCliente); 
    }
    
}
