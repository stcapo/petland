package com.petland.repository;

import com.petland.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    
    // 根据ID查询用户
    User findById(Integer id);
    
    // 根据用户名查询用户
    User findByUsername(String username);
    
    // 查询所有用户
    List<User> findAll();
    
    // 添加用户
    int insert(User user);
    
    // 更新用户
    int update(User user);
    
    // 删除用户
    int deleteById(Integer id);
    
    // 用户登录验证
    User login(@Param("username") String username, @Param("passwd") String passwd);
}
