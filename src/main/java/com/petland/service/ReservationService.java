package com.petland.service;

import com.petland.entity.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationService {
    
    // 根据ID查询预约
    Reservation findById(Integer id);
    
    // 查询所有预约
    List<Reservation> findAll();
    
    // 根据用户ID查询预约
    List<Reservation> findByUserId(Integer userId);
    
    // 根据宠物ID查询预约
    List<Reservation> findByPetId(Integer petId);
    
    // 根据预约类型查询预约
    List<Reservation> findByType(String type);
    
    // 根据预约状态查询预约
    List<Reservation> findByStatus(String status);
    
    // 根据预约时间范围查询预约
    List<Reservation> findByTimeRange(Date startTime, Date endTime);
    
    // 添加预约
    boolean insert(Reservation reservation);
    
    // 更新预约
    boolean update(Reservation reservation);
    
    // 删除预约
    boolean deleteById(Integer id);
}
