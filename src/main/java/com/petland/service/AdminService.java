package com.petland.service;

import com.petland.entity.Admin;

import java.util.List;

public interface AdminService {
    
    // 根据ID查询管理员
    Admin findById(Integer id);
    
    // 根据用户ID查询管理员
    Admin findByUserId(Integer userId);
    
    // 查询所有管理员
    List<Admin> findAll();
    
    // 添加管理员
    boolean insert(Admin admin);
    
    // 更新管理员
    boolean update(Admin admin);
    
    // 删除管理员
    boolean deleteById(Integer id);
}
