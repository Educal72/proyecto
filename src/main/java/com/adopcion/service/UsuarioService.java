
package ParteProyectoWeb.proyectowebDA.service;


import ParteProyectoWeb.proyectowebDA.domain.Usuario;
import java.util.List;


 
public interface UsuarioService {
  
    public List<Usuario> getUsuarios();
    
    
  
    public Usuario getUsuarios(Usuario usuario);
    
    
    public void save(Usuario usuario);
    
    
    
    public void delete(Usuario usuario);
    
    
}
