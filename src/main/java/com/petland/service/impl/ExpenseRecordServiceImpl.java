package com.petland.service.impl;

import com.petland.entity.ExpenseRecord;
import com.petland.repository.ExpenseRecordRepository;
import com.petland.service.ExpenseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class ExpenseRecordServiceImpl implements ExpenseRecordService {

    @Autowired
    private ExpenseRecordRepository expenseRecordRepository;
    
    @Override
    public ExpenseRecord findById(Integer id) {
        return expenseRecordRepository.findById(id);
    }

    @Override
    public List<ExpenseRecord> findAll() {
        return expenseRecordRepository.findAll();
    }

    @Override
    public List<ExpenseRecord> findByDescriptionLike(String keyword) {
        return expenseRecordRepository.findByDescriptionLike(keyword);
    }

    @Override
    public List<ExpenseRecord> findByAmountRange(BigDecimal minAmount, BigDecimal maxAmount) {
        return expenseRecordRepository.findByAmountRange(minAmount, maxAmount);
    }

    @Override
    public List<ExpenseRecord> findByTimeRange(Date startTime, Date endTime) {
        return expenseRecordRepository.findByTimeRange(startTime, endTime);
    }

    @Override
    public BigDecimal getTotalExpense() {
        return expenseRecordRepository.getTotalExpense();
    }

    @Override
    public BigDecimal getTotalExpenseByTimeRange(Date startTime, Date endTime) {
        return expenseRecordRepository.getTotalExpenseByTimeRange(startTime, endTime);
    }

    @Override
    public boolean insert(ExpenseRecord expenseRecord) {
        return expenseRecordRepository.insert(expenseRecord) > 0;
    }

    @Override
    public boolean update(ExpenseRecord expenseRecord) {
        return expenseRecordRepository.update(expenseRecord) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return expenseRecordRepository.deleteById(id) > 0;
    }
}
