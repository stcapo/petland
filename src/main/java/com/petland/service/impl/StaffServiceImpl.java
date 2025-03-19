package com.petland.service.impl;

import com.petland.entity.Staff;
import com.petland.repository.StaffRepository;
import com.petland.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;
    
    @Override
    public Staff findById(Integer id) {
        return staffRepository.findById(id);
    }

    @Override
    public Staff findByUserId(Integer userId) {
        return staffRepository.findByUserId(userId);
    }

    @Override
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    @Override
    public List<Staff> findByRole(String role) {
        return staffRepository.findByRole(role);
    }

    @Override
    public boolean insert(Staff staff) {
        return staffRepository.insert(staff) > 0;
    }

    @Override
    public boolean update(Staff staff) {
        return staffRepository.update(staff) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return staffRepository.deleteById(id) > 0;
    }
}
