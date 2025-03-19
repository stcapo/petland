package com.petland.repository;

import com.petland.entity.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository {
    
    // 根据ID查询管理员
    Admin findById(Integer id);
    
    // 根据用户ID查询管理员
    Admin findByUserId(Integer userId);
    
    // 查询所有管理员
    List<Admin> findAll();
    
    // 添加管理员
    int insert(Admin admin);
    
    // 更新管理员
    int update(Admin admin);
    
    // 删除管理员
    int deleteById(Integer id);
}
