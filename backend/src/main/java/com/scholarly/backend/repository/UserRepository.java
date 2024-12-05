package com.scholarly.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.scholarly.backend.model.User;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);

}
