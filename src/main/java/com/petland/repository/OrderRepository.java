package com.petland.repository;

import com.petland.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository {
    
    // 根据ID查询订单
    Order findById(Integer id);
    
    // 查询所有订单
    List<Order> findAll();
    
    // 根据用户ID查询订单
    List<Order> findByUserId(Integer userId);
    
    // 根据商品ID查询订单
    List<Order> findByProductId(Integer productId);
    
    // 根据订单状态查询订单
    List<Order> findByStatus(String status);
    
    // 根据订单创建时间范围查询订单
    List<Order> findByTimeRange(Date startTime, Date endTime);
    
    // 添加订单
    int insert(Order order);
    
    // 更新订单
    int update(Order order);
    
    // 更新订单状态
    int updateStatus(Integer id, String status);
    
    // 删除订单
    int deleteById(Integer id);
}
