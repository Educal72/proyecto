
package com.adopcion.service;


import com.adopcion.domain.User;
import java.util.List;

public interface UserService {
    
    public List<User> getUsers();

    public User getUsers(User user);
    
    public void save(User user);
     
    public void delete(User user);
    
    
}
