package com.petland.service.impl;

import com.petland.entity.Admin;
import com.petland.repository.AdminRepository;
import com.petland.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    
    @Override
    public Admin findById(Integer id) {
        return adminRepository.findById(id);
    }

    @Override
    public Admin findByUserId(Integer userId) {
        return adminRepository.findByUserId(userId);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public boolean insert(Admin admin) {
        return adminRepository.insert(admin) > 0;
    }

    @Override
    public boolean update(Admin admin) {
        return adminRepository.update(admin) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return adminRepository.deleteById(id) > 0;
    }
}
