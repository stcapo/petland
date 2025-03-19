package com.petland.controller;

import com.petland.entity.Reservation;
import com.petland.service.ReservationService;
import com.petland.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Reservation reservation = reservationService.findById(id);
        if (reservation != null) {
            return Result.success(reservation);
        } else {
            return Result.error("未找到该预约");
        }
    }
    
    @GetMapping
    public Result getAll() {
        List<Reservation> reservations = reservationService.findAll();
        return Result.success(reservations);
    }
    
    @GetMapping("/user/{userId}")
    public Result getByUserId(@PathVariable Integer userId) {
        List<Reservation> reservations = reservationService.findByUserId(userId);
        return Result.success(reservations);
    }
    
    @GetMapping("/pet/{petId}")
    public Result getByPetId(@PathVariable Integer petId) {
        List<Reservation> reservations = reservationService.findByPetId(petId);
        return Result.success(reservations);
    }
    
    @GetMapping("/type/{type}")
    public Result getByType(@PathVariable String type) {
        List<Reservation> reservations = reservationService.findByType(type);
        return Result.success(reservations);
    }
    
    @GetMapping("/status/{status}")
    public Result getByStatus(@PathVariable String status) {
        List<Reservation> reservations = reservationService.findByStatus(status);
        return Result.success(reservations);
    }
    
    @GetMapping("/time")
    public Result getByTimeRange(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
        List<Reservation> reservations = reservationService.findByTimeRange(startTime, endTime);
        return Result.success(reservations);
    }
    
    @PostMapping
    public Result add(@RequestBody Reservation reservation) {
        if (reservationService.insert(reservation)) {
            return Result.success("添加预约成功", reservation);
        } else {
            return Result.error("添加预约失败");
        }
    }
    
    @PutMapping
    public Result update(@RequestBody Reservation reservation) {
        Reservation existReservation = reservationService.findById(reservation.getId());
        if (existReservation == null) {
            return Result.error("未找到该预约");
        }
        
        if (reservationService.update(reservation)) {
            return Result.success("更新预约成功", reservation);
        } else {
            return Result.error("更新预约失败");
        }
    }
    
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        if (reservationService.deleteById(id)) {
            return Result.success("删除预约成功");
        } else {
            return Result.error("删除预约失败");
        }
    }
}
