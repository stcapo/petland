package com.petland.service;

import com.petland.entity.Staff;

import java.util.List;

public interface StaffService {
    
    // 根据ID查询员工
    Staff findById(Integer id);
    
    // 根据用户ID查询员工
    Staff findByUserId(Integer userId);
    
    // 查询所有员工
    List<Staff> findAll();
    
    // 根据角色查询员工
    List<Staff> findByRole(String role);
    
    // 添加员工
    boolean insert(Staff staff);
    
    // 更新员工
    boolean update(Staff staff);
    
    // 删除员工
    boolean deleteById(Integer id);
}
