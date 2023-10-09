package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.UserCredintial;

public interface UserCrediantialRepository extends JpaRepository<UserCredintial,Integer>{
    Optional<UserCredintial> findByName(String username);
}
