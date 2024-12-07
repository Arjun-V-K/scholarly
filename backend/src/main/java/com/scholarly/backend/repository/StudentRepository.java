package com.scholarly.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.scholarly.backend.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

}
