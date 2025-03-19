package com.petland.service.impl;

import com.petland.entity.Product;
import com.petland.repository.ProductRepository;
import com.petland.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.findByPriceRange(minPrice, maxPrice);
    }

    @Override
    public List<Product> findByStockStatus(boolean hasStock) {
        return productRepository.findByStockStatus(hasStock);
    }

    @Override
    public boolean insert(Product product) {
        return productRepository.insert(product) > 0;
    }

    @Override
    public boolean update(Product product) {
        return productRepository.update(product) > 0;
    }

    @Override
    public boolean updateStock(Integer id, Integer stock) {
        return productRepository.updateStock(id, stock) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return productRepository.deleteById(id) > 0;
    }
}
