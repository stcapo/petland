package com.petland.controller;

import com.petland.entity.Admin;
import com.petland.entity.User;
import com.petland.service.AdminService;
import com.petland.service.UserService;
import com.petland.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Admin admin = adminService.findById(id);
        if (admin != null) {
            return Result.success(admin);
        } else {
            return Result.error("未找到该管理员");
        }
    }
    
    @GetMapping
    public Result getAll() {
        List<Admin> admins = adminService.findAll();
        return Result.success(admins);
    }
    
    @PostMapping
    public Result add(@RequestBody Admin admin) {
        User user = userService.findById(admin.getUserId());
        if (user == null) {
            return Result.error("关联的用户不存在");
        }
        
        if (adminService.findByUserId(admin.getUserId()) != null) {
            return Result.error("该用户已经是管理员");
        }
        
        if (adminService.insert(admin)) {
            // 更新用户角色为admin
            user.setRole("admin");
            userService.update(user);
            return Result.success("添加管理员成功", admin);
        } else {
            return Result.error("添加管理员失败");
        }
    }
    
    @PutMapping
    public Result update(@RequestBody Admin admin) {
        Admin existAdmin = adminService.findById(admin.getId());
        if (existAdmin == null) {
            return Result.error("未找到该管理员");
        }
        
        if (adminService.update(admin)) {
            return Result.success("更新管理员成功", admin);
        } else {
            return Result.error("更新管理员失败");
        }
    }
    
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        Admin admin = adminService.findById(id);
        if (admin == null) {
            return Result.error("未找到该管理员");
        }
        
        if (adminService.deleteById(id)) {
            // 更新用户角色为user
            User user = userService.findById(admin.getUserId());
            if (user != null) {
                user.setRole("user");
                userService.update(user);
            }
            return Result.success("删除管理员成功");
        } else {
            return Result.error("删除管理员失败");
        }
    }
}
