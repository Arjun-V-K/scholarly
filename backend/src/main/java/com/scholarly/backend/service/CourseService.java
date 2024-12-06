package com.scholarly.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scholarly.backend.model.Course;
import com.scholarly.backend.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(String id) {
        return courseRepository.findById(id);
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> updateCourse(String id, Course course) {
        // If exists, then save over it
        // If not return an empty Optional
        return courseRepository.findById(id)
                .map(existingCourse -> {
                    course.setId(id);
                    return courseRepository.save(course);
                });
    }

    public boolean deleteCourse(String id) {
        if (!courseRepository.existsById(id)) {
            return false;
        }
        courseRepository.deleteById(id);
        return true;
    }

}
