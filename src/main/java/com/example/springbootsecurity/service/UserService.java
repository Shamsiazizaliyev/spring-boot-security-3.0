package com.example.springbootsecurity.service;

import com.example.springbootsecurity.entity.User;
import com.example.springbootsecurity.repository.UserRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepostory repository;
    @Autowired
   PasswordEncoder passwordEncoder;

    public String addUser(User userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added to system ";
    }
}
