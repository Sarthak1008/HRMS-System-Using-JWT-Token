package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.UserCredintial;
import com.example.demo.repositories.UserCrediantialRepository;

@Service
public class UserAuth {
    
    @Autowired
    private UserCrediantialRepository userCrediantialRepository;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String saveUser(UserCredintial credintial){
        credintial.setPassword(passwordEncoder.encode(credintial.getPassword()));
        userCrediantialRepository.save(credintial);
        String s = "user added to the system successfully";
        return s;
    }

    public String generateToken(String username){
        return jwtService.generateToken(username);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }
}
