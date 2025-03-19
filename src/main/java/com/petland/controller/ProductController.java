package com.petland.controller;

import com.petland.entity.Product;
import com.petland.service.ProductService;
import com.petland.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Product product = productService.findById(id);
        if (product != null) {
            return Result.success(product);
        } else {
            return Result.error("未找到该商品");
        }
    }
    
    @GetMapping
    public Result getAll() {
        List<Product> products = productService.findAll();
        return Result.success(products);
    }
    
    @GetMapping("/price")
    public Result getByPriceRange(
            @RequestParam BigDecimal minPrice,
            @RequestParam BigDecimal maxPrice) {
        List<Product> products = productService.findByPriceRange(minPrice, maxPrice);
        return Result.success(products);
    }
    
    @GetMapping("/stock")
    public Result getByStockStatus(@RequestParam boolean hasStock) {
        List<Product> products = productService.findByStockStatus(hasStock);
        return Result.success(products);
    }
    
    @PostMapping
    public Result add(@RequestBody Product product) {
        if (productService.insert(product)) {
            return Result.success("添加商品成功", product);
        } else {
            return Result.error("添加商品失败");
        }
    }
    
    @PutMapping
    public Result update(@RequestBody Product product) {
        Product existProduct = productService.findById(product.getId());
        if (existProduct == null) {
            return Result.error("未找到该商品");
        }
        
        if (productService.update(product)) {
            return Result.success("更新商品成功", product);
        } else {
            return Result.error("更新商品失败");
        }
    }
    
    @PutMapping("/stock/{id}")
    public Result updateStock(
            @PathVariable Integer id,
            @RequestParam Integer stock) {
        Product existProduct = productService.findById(id);
        if (existProduct == null) {
            return Result.error("未找到该商品");
        }
        
        if (productService.updateStock(id, stock)) {
            return Result.success("更新商品库存成功");
        } else {
            return Result.error("更新商品库存失败");
        }
    }
    
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        if (productService.deleteById(id)) {
            return Result.success("删除商品成功");
        } else {
            return Result.error("删除商品失败");
        }
    }
}
