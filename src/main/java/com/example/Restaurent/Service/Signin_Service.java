package com.example.Restaurent.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Restaurent.Reporsitory.Signin_Reporsitory;
import com.example.Restaurent.entity.Signin;

@Service
public class Signin_Service {

    @Autowired
    private Signin_Reporsitory signinRepository;

    // Save new user
    public void save(Signin user) {
        signinRepository.save(user);
    }

    // Find user by email
    public Signin getUserByEmail(String email) {
        return signinRepository.findByEmail(email);
    }

    // Authenticate user
    public boolean authenticateUser(String email, String password) {
        Signin user = signinRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
    public List<Signin> getAllBook()
    {
  		return signinRepository.findAll();
    }
}
