package com.petland.service.impl;

import com.petland.entity.Reservation;
import com.petland.repository.ReservationRepository;
import com.petland.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    
    @Override
    public Reservation findById(Integer id) {
        return reservationRepository.findById(id);
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> findByUserId(Integer userId) {
        return reservationRepository.findByUserId(userId);
    }

    @Override
    public List<Reservation> findByPetId(Integer petId) {
        return reservationRepository.findByPetId(petId);
    }

    @Override
    public List<Reservation> findByType(String type) {
        return reservationRepository.findByType(type);
    }

    @Override
    public List<Reservation> findByStatus(String status) {
        return reservationRepository.findByStatus(status);
    }

    @Override
    public List<Reservation> findByTimeRange(Date startTime, Date endTime) {
        return reservationRepository.findByTimeRange(startTime, endTime);
    }

    @Override
    public boolean insert(Reservation reservation) {
        return reservationRepository.insert(reservation) > 0;
    }

    @Override
    public boolean update(Reservation reservation) {
        return reservationRepository.update(reservation) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return reservationRepository.deleteById(id) > 0;
    }
}
