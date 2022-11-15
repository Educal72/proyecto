
package com.adopcion.service;

import com.adopcion.dao.UsuariosDao;
import com.adopcion.domain.Usuarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuariosDao usuarioDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Usuarios> getUsuarios() {
        return (List<Usuarios>)usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Usuarios getUsuarios(Usuarios usuarios) {
        return usuarioDao.findById(usuarios.getIdUsuario()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Usuarios usuarios) {
        usuarioDao.save(usuarios);

    }

    @Override
    @Transactional
    public void delete(Usuarios usuarios) {
        usuarioDao.delete(usuarios);

    }
}
