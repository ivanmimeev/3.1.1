package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUser() {
        return userRepository.findAll();
    }

    @Transactional
    public User add(User user) {
        return userRepository.save(user);
    }

    public User getById(long id) {
        return userRepository.getOne(id);
    }
    @Transactional
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
