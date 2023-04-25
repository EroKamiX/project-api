package com.itplus.api.service;

import com.itplus.api.model.Course;
import com.itplus.api.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CourseService implements Services<Course>{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void delete(long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void update(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Optional<Course> findById(long id) {
        return courseRepository.findById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
