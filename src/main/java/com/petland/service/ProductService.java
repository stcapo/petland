package com.petland.service;

import com.petland.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    
    // 根据ID查询商品
    Product findById(Integer id);
    
    // 查询所有商品
    List<Product> findAll();
    
    // 根据价格范围查询商品
    List<Product> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
    
    // 根据库存状态查询商品（是否有库存）
    List<Product> findByStockStatus(boolean hasStock);
    
    // 添加商品
    boolean insert(Product product);
    
    // 更新商品
    boolean update(Product product);
    
    // 更新商品库存
    boolean updateStock(Integer id, Integer stock);
    
    // 删除商品
    boolean deleteById(Integer id);
}
