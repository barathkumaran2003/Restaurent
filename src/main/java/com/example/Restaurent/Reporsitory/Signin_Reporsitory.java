package com.example.Restaurent.Reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Restaurent.entity.Signin;

@Repository
public interface Signin_Reporsitory extends JpaRepository<Signin, Long> {
    Signin findByEmail(String email);
}
