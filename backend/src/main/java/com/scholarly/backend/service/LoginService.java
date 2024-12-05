package com.scholarly.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scholarly.backend.model.LoginRequest;
import com.scholarly.backend.model.User;
import com.scholarly.backend.repository.UserRepository;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(LoginRequest loginRequest) {
        // TODO: JWT Token
        Optional<User> userOptional = userRepository.findByUsername(loginRequest.getUsername());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return loginRequest.getPassword().equals(user.getPassword());
        }
        return false;
    }

}
