package com.scholarly.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scholarly.backend.model.LoginRequest;
import com.scholarly.backend.model.User;
import com.scholarly.backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

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
