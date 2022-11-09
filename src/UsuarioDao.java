
package ParteProyectoWeb.proyectowebDA.dao;


import ParteProyectoWeb.proyectowebDA.domain.Usuario;
import org.springframework.data.repository.CrudRepository;


public interface UsuarioDao extends CrudRepository<Usuario, Long>{
    
    
}
