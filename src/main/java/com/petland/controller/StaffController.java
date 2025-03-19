package com.petland.controller;

import com.petland.entity.Staff;
import com.petland.entity.User;
import com.petland.service.StaffService;
import com.petland.service.UserService;
import com.petland.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Staff staff = staffService.findById(id);
        if (staff != null) {
            return Result.success(staff);
        } else {
            return Result.error("未找到该员工");
        }
    }
    
    @GetMapping
    public Result getAll() {
        List<Staff> staffs = staffService.findAll();
        return Result.success(staffs);
    }
    
    @GetMapping("/role/{role}")
    public Result getByRole(@PathVariable String role) {
        List<Staff> staffs = staffService.findByRole(role);
        return Result.success(staffs);
    }
    
    @PostMapping
    public Result add(@RequestBody Staff staff) {
        User user = userService.findById(staff.getUserId());
        if (user == null) {
            return Result.error("关联的用户不存在");
        }
        
        if (staffService.findByUserId(staff.getUserId()) != null) {
            return Result.error("该用户已经是员工");
        }
        
        if (staffService.insert(staff)) {
            // 更新用户角色为staff
            user.setRole("staff");
            userService.update(user);
            return Result.success("添加员工成功", staff);
        } else {
            return Result.error("添加员工失败");
        }
    }
    
    @PutMapping
    public Result update(@RequestBody Staff staff) {
        Staff existStaff = staffService.findById(staff.getId());
        if (existStaff == null) {
            return Result.error("未找到该员工");
        }
        
        if (staffService.update(staff)) {
            return Result.success("更新员工成功", staff);
        } else {
            return Result.error("更新员工失败");
        }
    }
    
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        Staff staff = staffService.findById(id);
        if (staff == null) {
            return Result.error("未找到该员工");
        }
        
        if (staffService.deleteById(id)) {
            // 更新用户角色为user
            User user = userService.findById(staff.getUserId());
            if (user != null) {
                user.setRole("user");
                userService.update(user);
            }
            return Result.success("删除员工成功");
        } else {
            return Result.error("删除员工失败");
        }
    }
}
