
package com.adopcion.service;



import com.adopcion.dao.UsuarioDao;
import com.adopcion.domain.Rol;
import com.adopcion.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DYL4N16199
 */
@Service
public class UsuarioService implements UserDetailsService{
    
    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        //Buscar el ususario en la tabla de usuarios
        Usuario usuario= usuarioDao.findByUsername(username);
        
        //Se verifica que el usuario existe.... sino se lanza una excepcion
        if(usuario==null){
            throw new UsernameNotFoundException(username);
        }
        
        //Se cargan los roles del usuario
        var roles= new ArrayList<GrantedAuthority>();
        

//Por medio de la asociacion se recuperan los roles de la tabla de roles
        for(Rol rol: usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
            
        }
        return new User(usuario.getUsername(),usuario.getPassword(),roles);
        
    }
    
}

