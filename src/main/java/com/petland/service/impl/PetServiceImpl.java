package com.petland.service.impl;

import com.petland.entity.Pet;
import com.petland.repository.PetRepository;
import com.petland.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;
    
    @Override
    public Pet findById(Integer id) {
        return petRepository.findById(id);
    }

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public List<Pet> findByType(String type) {
        return petRepository.findByType(type);
    }

    @Override
    public List<Pet> findByStatus(String status) {
        return petRepository.findByStatus(status);
    }

    @Override
    public boolean insert(Pet pet) {
        return petRepository.insert(pet) > 0;
    }

    @Override
    public boolean update(Pet pet) {
        return petRepository.update(pet) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return petRepository.deleteById(id) > 0;
    }
}
