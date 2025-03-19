package com.petland.service;

import com.petland.entity.Pet;

import java.util.List;

public interface PetService {
    
    // 根据ID查询宠物
    Pet findById(Integer id);
    
    // 查询所有宠物
    List<Pet> findAll();
    
    // 根据类型查询宠物
    List<Pet> findByType(String type);
    
    // 根据状态查询宠物
    List<Pet> findByStatus(String status);
    
    // 添加宠物
    boolean insert(Pet pet);
    
    // 更新宠物
    boolean update(Pet pet);
    
    // 删除宠物
    boolean deleteById(Integer id);
}
