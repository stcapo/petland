package com.petland.repository;

import com.petland.entity.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository {
    
    // 根据ID查询员工
    Staff findById(Integer id);
    
    // 根据用户ID查询员工
    Staff findByUserId(Integer userId);
    
    // 查询所有员工
    List<Staff> findAll();
    
    // 根据角色查询员工
    List<Staff> findByRole(String role);
    
    // 添加员工
    int insert(Staff staff);
    
    // 更新员工
    int update(Staff staff);
    
    // 删除员工
    int deleteById(Integer id);
}
