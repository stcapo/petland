package com.petland.service;

import com.petland.entity.IncomeRecord;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface IncomeRecordService {
    
    // 根据ID查询收入记录
    IncomeRecord findById(Integer id);
    
    // 查询所有收入记录
    List<IncomeRecord> findAll();
    
    // 根据订单ID查询收入记录
    List<IncomeRecord> findByOrderId(Integer orderId);
    
    // 根据金额范围查询收入记录
    List<IncomeRecord> findByAmountRange(BigDecimal minAmount, BigDecimal maxAmount);
    
    // 根据创建时间范围查询收入记录
    List<IncomeRecord> findByTimeRange(Date startTime, Date endTime);
    
    // 查询总收入
    BigDecimal getTotalIncome();
    
    // 查询指定时间范围内的总收入
    BigDecimal getTotalIncomeByTimeRange(Date startTime, Date endTime);
    
    // 添加收入记录
    boolean insert(IncomeRecord incomeRecord);
    
    // 更新收入记录
    boolean update(IncomeRecord incomeRecord);
    
    // 删除收入记录
    boolean deleteById(Integer id);
}
