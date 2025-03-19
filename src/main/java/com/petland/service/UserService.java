package com.petland.service;

import com.petland.entity.User;

import java.util.List;

public interface UserService {
    
    // 根据ID查询用户
    User findById(Integer id);
    
    // 根据用户名查询用户
    User findByUsername(String username);
    
    // 查询所有用户
    List<User> findAll();
    
    // 添加用户
    boolean insert(User user);
    
    // 更新用户
    boolean update(User user);
    
    // 删除用户
    boolean deleteById(Integer id);
    
    // 用户登录验证
    User login(String username, String passwd);
}
