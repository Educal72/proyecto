
package com.adopcion.service;

import com.adopcion.domain.Animal;
import java.util.List;

public interface AnimalService {
    
    public List<Animal> getAnimales();
    
    public Animal getAnimal(Animal animal);
    
    public void save(Animal animal);
    
    public void delete(Animal animal);
}
