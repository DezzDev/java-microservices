package com.microservice.course.services;

import com.microservice.course.entities.Course;

import java.util.List;

public interface ICourseService {
    List<Course> findAll();

    Course findById(long id);

    void save(Course course);
}
