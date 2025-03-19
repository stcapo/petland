package com.petland.controller;

import com.petland.entity.Pet;
import com.petland.service.PetService;
import com.petland.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pet")
public class PetController {

    @Autowired
    private PetService petService;
    
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Pet pet = petService.findById(id);
        if (pet != null) {
            return Result.success(pet);
        } else {
            return Result.error("未找到该宠物");
        }
    }
    
    @GetMapping
    public Result getAll() {
        List<Pet> pets = petService.findAll();
        return Result.success(pets);
    }
    
    @GetMapping("/type/{type}")
    public Result getByType(@PathVariable String type) {
        List<Pet> pets = petService.findByType(type);
        return Result.success(pets);
    }
    
    @GetMapping("/status/{status}")
    public Result getByStatus(@PathVariable String status) {
        List<Pet> pets = petService.findByStatus(status);
        return Result.success(pets);
    }
    
    @PostMapping
    public Result add(@RequestBody Pet pet) {
        if (petService.insert(pet)) {
            return Result.success("添加宠物成功", pet);
        } else {
            return Result.error("添加宠物失败");
        }
    }
    
    @PutMapping
    public Result update(@RequestBody Pet pet) {
        Pet existPet = petService.findById(pet.getId());
        if (existPet == null) {
            return Result.error("未找到该宠物");
        }
        
        if (petService.update(pet)) {
            return Result.success("更新宠物成功", pet);
        } else {
            return Result.error("更新宠物失败");
        }
    }
    
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        if (petService.deleteById(id)) {
            return Result.success("删除宠物成功");
        } else {
            return Result.error("删除宠物失败");
        }
    }
}
