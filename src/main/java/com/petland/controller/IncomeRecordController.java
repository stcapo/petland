package com.petland.controller;

import com.petland.entity.IncomeRecord;
import com.petland.service.IncomeRecordService;
import com.petland.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeRecordController {

    @Autowired
    private IncomeRecordService incomeRecordService;
    
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        IncomeRecord incomeRecord = incomeRecordService.findById(id);
        if (incomeRecord != null) {
            return Result.success(incomeRecord);
        } else {
            return Result.error("未找到该收入记录");
        }
    }
    
    @GetMapping
    public Result getAll() {
        List<IncomeRecord> incomeRecords = incomeRecordService.findAll();
        return Result.success(incomeRecords);
    }
    
    @GetMapping("/order/{orderId}")
    public Result getByOrderId(@PathVariable Integer orderId) {
        List<IncomeRecord> incomeRecords = incomeRecordService.findByOrderId(orderId);
        return Result.success(incomeRecords);
    }
    
    @GetMapping("/amount")
    public Result getByAmountRange(
            @RequestParam BigDecimal minAmount,
            @RequestParam BigDecimal maxAmount) {
        List<IncomeRecord> incomeRecords = incomeRecordService.findByAmountRange(minAmount, maxAmount);
        return Result.success(incomeRecords);
    }
    
    @GetMapping("/time")
    public Result getByTimeRange(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
        List<IncomeRecord> incomeRecords = incomeRecordService.findByTimeRange(startTime, endTime);
        return Result.success(incomeRecords);
    }
    
    @GetMapping("/total")
    public Result getTotalIncome() {
        BigDecimal totalIncome = incomeRecordService.getTotalIncome();
        return Result.success(totalIncome);
    }
    
    @GetMapping("/total/time")
    public Result getTotalIncomeByTimeRange(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
        BigDecimal totalIncome = incomeRecordService.getTotalIncomeByTimeRange(startTime, endTime);
        return Result.success(totalIncome);
    }
    
    @PostMapping
    public Result add(@RequestBody IncomeRecord incomeRecord) {
        if (incomeRecordService.insert(incomeRecord)) {
            return Result.success("添加收入记录成功", incomeRecord);
        } else {
            return Result.error("添加收入记录失败");
        }
    }
    
    @PutMapping
    public Result update(@RequestBody IncomeRecord incomeRecord) {
        IncomeRecord existIncomeRecord = incomeRecordService.findById(incomeRecord.getId());
        if (existIncomeRecord == null) {
            return Result.error("未找到该收入记录");
        }
        
        if (incomeRecordService.update(incomeRecord)) {
            return Result.success("更新收入记录成功", incomeRecord);
        } else {
            return Result.error("更新收入记录失败");
        }
    }
    
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        if (incomeRecordService.deleteById(id)) {
            return Result.success("删除收入记录成功");
        } else {
            return Result.error("删除收入记录失败");
        }
    }
}
