package com.petland.controller;

import com.petland.entity.User;
import com.petland.service.UserService;
import com.petland.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        User user = userService.findById(id);
        if (user != null) {
            return Result.success(user);
        } else {
            return Result.error("未找到该用户");
        }
    }
    
    @GetMapping
    public Result getAll() {
        List<User> users = userService.findAll();
        return Result.success(users);
    }
    
    @PostMapping
    public Result add(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            return Result.error("用户名已存在");
        }
        
        if (userService.insert(user)) {
            return Result.success("添加用户成功", user);
        } else {
            return Result.error("添加用户失败");
        }
    }
    
    @PutMapping
    public Result update(@RequestBody User user) {
        User existUser = userService.findById(user.getId());
        if (existUser == null) {
            return Result.error("未找到该用户");
        }
        
        if (userService.update(user)) {
            return Result.success("更新用户成功", user);
        } else {
            return Result.error("更新用户失败");
        }
    }
    
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        if (userService.deleteById(id)) {
            return Result.success("删除用户成功");
        } else {
            return Result.error("删除用户失败");
        }
    }
    
    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpSession session) {
        User loginUser = userService.login(user.getUsername(), user.getPasswd());
        if (loginUser != null) {
            // 将用户信息存入session
            session.setAttribute("user", loginUser);
            return Result.success("登录成功", loginUser);
        } else {
            return Result.error("用户名或密码错误");
        }
    }
    
    @PostMapping("/logout")
    public Result logout(HttpSession session) {
        session.removeAttribute("user");
        return Result.success("退出登录成功");
    }
}
