package com.petland.service.impl;

import com.petland.entity.Order;
import com.petland.repository.OrderRepository;
import com.petland.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findByUserId(Integer userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public List<Order> findByProductId(Integer productId) {
        return orderRepository.findByProductId(productId);
    }

    @Override
    public List<Order> findByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    @Override
    public List<Order> findByTimeRange(Date startTime, Date endTime) {
        return orderRepository.findByTimeRange(startTime, endTime);
    }

    @Override
    public boolean insert(Order order) {
        return orderRepository.insert(order) > 0;
    }

    @Override
    public boolean update(Order order) {
        return orderRepository.update(order) > 0;
    }

    @Override
    public boolean updateStatus(Integer id, String status) {
        return orderRepository.updateStatus(id, status) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return orderRepository.deleteById(id) > 0;
    }
}
