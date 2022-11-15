
package com.adopcion.service;

import com.adopcion.domain.Usuarios;
import java.util.List;

public interface UsuarioService {
    
    public List<Usuarios> getUsuarios();

    public Usuarios getUsuarios(Usuarios usuarios);
    
    public void save(Usuarios usuarios);
     
    public void delete(Usuarios usuarios);
}
