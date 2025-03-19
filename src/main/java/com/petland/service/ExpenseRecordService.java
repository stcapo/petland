package com.petland.service;

import com.petland.entity.ExpenseRecord;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface ExpenseRecordService {
    
    // 根据ID查询支出记录
    ExpenseRecord findById(Integer id);
    
    // 查询所有支出记录
    List<ExpenseRecord> findAll();
    
    // 根据描述关键词查询支出记录
    List<ExpenseRecord> findByDescriptionLike(String keyword);
    
    // 根据金额范围查询支出记录
    List<ExpenseRecord> findByAmountRange(BigDecimal minAmount, BigDecimal maxAmount);
    
    // 根据创建时间范围查询支出记录
    List<ExpenseRecord> findByTimeRange(Date startTime, Date endTime);
    
    // 查询总支出
    BigDecimal getTotalExpense();
    
    // 查询指定时间范围内的总支出
    BigDecimal getTotalExpenseByTimeRange(Date startTime, Date endTime);
    
    // 添加支出记录
    boolean insert(ExpenseRecord expenseRecord);
    
    // 更新支出记录
    boolean update(ExpenseRecord expenseRecord);
    
    // 删除支出记录
    boolean deleteById(Integer id);
}
