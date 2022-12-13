
package com.adopcion.dao;



import com.adopcion.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao 
        extends JpaRepository<Usuario, Long>{
    
    //Consultas ampliadas de JPA
    public Usuario findByUsername(String username);
    
}
