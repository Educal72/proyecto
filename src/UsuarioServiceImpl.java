
package ParteProyectoWeb.proyectowebDA.service;

import ParteProyectoWeb.proyectowebDA.dao.UsuarioDao;
import ParteProyectoWeb.proyectowebDA.domain.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DYL4N16199
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{
   
    @Autowired
    private UsuarioDao usuarioDao;
    
    
   
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios(){
        return(List<Usuario>)usuarioDao.findAll();
        
    }
    
    
    
    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarios(Usuario usuario){
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
        
    }
    
    
    
    @Override
    @Transactional
    public void save(Cliente cliente){
        clienteDao.save(cliente);
        
        
    }
    
    
    
    @Override
    @Transactional
    public void delete(Cliente cliente){
        clienteDao.delete(cliente);
    }
    
    
}
