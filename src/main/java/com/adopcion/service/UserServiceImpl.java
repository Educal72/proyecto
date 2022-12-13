
package com.adopcion.service;


import com.adopcion.dao.UserDao;

import com.adopcion.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserDao userDao;
    
   @Override
    @Transactional(readOnly=true)
    public List<User> getUsers() {
        return (List<User>)userDao.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public User getUsers(User user) {
        return userDao.findById(user.getIdUsuario()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);

    }

    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);

    }
}
