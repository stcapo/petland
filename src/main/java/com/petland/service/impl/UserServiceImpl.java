package com.petland.service.impl;

import com.petland.entity.User;
import com.petland.repository.UserRepository;
import com.petland.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public User findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean insert(User user) {
        return userRepository.insert(user) > 0;
    }

    @Override
    public boolean update(User user) {
        return userRepository.update(user) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return userRepository.deleteById(id) > 0;
    }

    @Override
    public User login(String username, String passwd) {
        return userRepository.login(username, passwd);
    }
}
