/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adopcion.service;


import com.adopcion.dao.AnimalDao;
import com.adopcion.domain.Animal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnimalServiceImpl implements AnimalService{
    @Autowired
    private AnimalDao animalDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Animal> getAnimales() {
        return (List<Animal>)animalDao.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Animal getAnimal(Animal animal) {
        return animalDao.findById(animal.getIdAnimal()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Animal animal) {
        animalDao.save(animal);

    }

    @Override
    @Transactional
    public void delete(Animal animal) {
        animalDao.delete(animal);

    }
}
