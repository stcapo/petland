package com.petland.service.impl;

import com.petland.entity.IncomeRecord;
import com.petland.repository.IncomeRecordRepository;
import com.petland.service.IncomeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class IncomeRecordServiceImpl implements IncomeRecordService {

    @Autowired
    private IncomeRecordRepository incomeRecordRepository;
    
    @Override
    public IncomeRecord findById(Integer id) {
        return incomeRecordRepository.findById(id);
    }

    @Override
    public List<IncomeRecord> findAll() {
        return incomeRecordRepository.findAll();
    }

    @Override
    public List<IncomeRecord> findByOrderId(Integer orderId) {
        return incomeRecordRepository.findByOrderId(orderId);
    }

    @Override
    public List<IncomeRecord> findByAmountRange(BigDecimal minAmount, BigDecimal maxAmount) {
        return incomeRecordRepository.findByAmountRange(minAmount, maxAmount);
    }

    @Override
    public List<IncomeRecord> findByTimeRange(Date startTime, Date endTime) {
        return incomeRecordRepository.findByTimeRange(startTime, endTime);
    }

    @Override
    public BigDecimal getTotalIncome() {
        return incomeRecordRepository.getTotalIncome();
    }

    @Override
    public BigDecimal getTotalIncomeByTimeRange(Date startTime, Date endTime) {
        return incomeRecordRepository.getTotalIncomeByTimeRange(startTime, endTime);
    }

    @Override
    public boolean insert(IncomeRecord incomeRecord) {
        return incomeRecordRepository.insert(incomeRecord) > 0;
    }

    @Override
    public boolean update(IncomeRecord incomeRecord) {
        return incomeRecordRepository.update(incomeRecord) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return incomeRecordRepository.deleteById(id) > 0;
    }
}
