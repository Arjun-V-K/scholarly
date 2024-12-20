package com.scholarly.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.scholarly.backend.model.Course;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {

}
