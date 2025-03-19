package com.petland.controller;

import com.petland.entity.IncomeRecord;
import com.petland.entity.Order;
import com.petland.entity.Product;
import com.petland.service.IncomeRecordService;
import com.petland.service.OrderService;
import com.petland.service.ProductService;
import com.petland.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private IncomeRecordService incomeRecordService;
    
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Order order = orderService.findById(id);
        if (order != null) {
            return Result.success(order);
        } else {
            return Result.error("未找到该订单");
        }
    }
    
    @GetMapping
    public Result getAll() {
        List<Order> orders = orderService.findAll();
        return Result.success(orders);
    }
    
    @GetMapping("/user/{userId}")
    public Result getByUserId(@PathVariable Integer userId) {
        List<Order> orders = orderService.findByUserId(userId);
        return Result.success(orders);
    }
    
    @GetMapping("/product/{productId}")
    public Result getByProductId(@PathVariable Integer productId) {
        List<Order> orders = orderService.findByProductId(productId);
        return Result.success(orders);
    }
    
    @GetMapping("/status/{status}")
    public Result getByStatus(@PathVariable String status) {
        List<Order> orders = orderService.findByStatus(status);
        return Result.success(orders);
    }
    
    @GetMapping("/time")
    public Result getByTimeRange(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
        List<Order> orders = orderService.findByTimeRange(startTime, endTime);
        return Result.success(orders);
    }
    
    @PostMapping
    public Result add(@RequestBody Order order) {
        // 检查商品是否存在
        Product product = productService.findById(order.getProductId());
        if (product == null) {
            return Result.error("商品不存在");
        }
        
        // 检查库存是否足够
        if (product.getStock() < order.getQuantity()) {
            return Result.error("商品库存不足");
        }
        
        // 创建订单
        if (orderService.insert(order)) {
            // 减少商品库存
            productService.updateStock(product.getId(), product.getStock() - order.getQuantity());
            
            // 如果订单状态为已支付，创建收入记录
            if ("已支付".equals(order.getStatus())) {
                IncomeRecord incomeRecord = new IncomeRecord();
                incomeRecord.setOrderId(order.getId());
                incomeRecord.setAmount(order.getTotalPrice());
                incomeRecordService.insert(incomeRecord);
            }
            
            return Result.success("添加订单成功", order);
        } else {
            return Result.error("添加订单失败");
        }
    }
    
    @PutMapping
    public Result update(@RequestBody Order order) {
        Order existOrder = orderService.findById(order.getId());
        if (existOrder == null) {
            return Result.error("未找到该订单");
        }
        
        if (orderService.update(order)) {
            return Result.success("更新订单成功", order);
        } else {
            return Result.error("更新订单失败");
        }
    }
    
    @PutMapping("/status/{id}")
    public Result updateStatus(
            @PathVariable Integer id,
            @RequestParam String status) {
        Order existOrder = orderService.findById(id);
        if (existOrder == null) {
            return Result.error("未找到该订单");
        }
        
        if (orderService.updateStatus(id, status)) {
            // 如果状态从其他状态变为已支付，创建收入记录
            if ("已支付".equals(status) && !"已支付".equals(existOrder.getStatus())) {
                IncomeRecord incomeRecord = new IncomeRecord();
                incomeRecord.setOrderId(id);
                incomeRecord.setAmount(existOrder.getTotalPrice());
                incomeRecordService.insert(incomeRecord);
            }
            
            return Result.success("更新订单状态成功");
        } else {
            return Result.error("更新订单状态失败");
        }
    }
    
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        if (orderService.deleteById(id)) {
            return Result.success("删除订单成功");
        } else {
            return Result.error("删除订单失败");
        }
    }
}
