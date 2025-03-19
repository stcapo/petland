package com.petland.repository;

import com.petland.entity.Pet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository {
    
    // 根据ID查询宠物
    Pet findById(Integer id);
    
    // 查询所有宠物
    List<Pet> findAll();
    
    // 根据类型查询宠物
    List<Pet> findByType(String type);
    
    // 根据状态查询宠物
    List<Pet> findByStatus(String status);
    
    // 添加宠物
    int insert(Pet pet);
    
    // 更新宠物
    int update(Pet pet);
    
    // 删除宠物
    int deleteById(Integer id);
}
