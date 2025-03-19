package com.petland.controller;

import com.petland.entity.ExpenseRecord;
import com.petland.service.ExpenseRecordService;
import com.petland.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseRecordController {

    @Autowired
    private ExpenseRecordService expenseRecordService;
    
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        ExpenseRecord expenseRecord = expenseRecordService.findById(id);
        if (expenseRecord != null) {
            return Result.success(expenseRecord);
        } else {
            return Result.error("未找到该支出记录");
        }
    }
    
    @GetMapping
    public Result getAll() {
        List<ExpenseRecord> expenseRecords = expenseRecordService.findAll();
        return Result.success(expenseRecords);
    }
    
    @GetMapping("/description")
    public Result getByDescriptionLike(@RequestParam String keyword) {
        List<ExpenseRecord> expenseRecords = expenseRecordService.findByDescriptionLike(keyword);
        return Result.success(expenseRecords);
    }
    
    @GetMapping("/amount")
    public Result getByAmountRange(
            @RequestParam BigDecimal minAmount,
            @RequestParam BigDecimal maxAmount) {
        List<ExpenseRecord> expenseRecords = expenseRecordService.findByAmountRange(minAmount, maxAmount);
        return Result.success(expenseRecords);
    }
    
    @GetMapping("/time")
    public Result getByTimeRange(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
        List<ExpenseRecord> expenseRecords = expenseRecordService.findByTimeRange(startTime, endTime);
        return Result.success(expenseRecords);
    }
    
    @GetMapping("/total")
    public Result getTotalExpense() {
        BigDecimal totalExpense = expenseRecordService.getTotalExpense();
        return Result.success(totalExpense);
    }
    
    @GetMapping("/total/time")
    public Result getTotalExpenseByTimeRange(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
        BigDecimal totalExpense = expenseRecordService.getTotalExpenseByTimeRange(startTime, endTime);
        return Result.success(totalExpense);
    }
    
    @PostMapping
    public Result add(@RequestBody ExpenseRecord expenseRecord) {
        if (expenseRecordService.insert(expenseRecord)) {
            return Result.success("添加支出记录成功", expenseRecord);
        } else {
            return Result.error("添加支出记录失败");
        }
    }
    
    @PutMapping
    public Result update(@RequestBody ExpenseRecord expenseRecord) {
        ExpenseRecord existExpenseRecord = expenseRecordService.findById(expenseRecord.getId());
        if (existExpenseRecord == null) {
            return Result.error("未找到该支出记录");
        }
        
        if (expenseRecordService.update(expenseRecord)) {
            return Result.success("更新支出记录成功", expenseRecord);
        } else {
            return Result.error("更新支出记录失败");
        }
    }
    
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        if (expenseRecordService.deleteById(id)) {
            return Result.success("删除支出记录成功");
        } else {
            return Result.error("删除支出记录失败");
        }
    }
}
