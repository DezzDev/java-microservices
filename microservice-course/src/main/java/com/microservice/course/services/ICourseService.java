package com.microservice.course.services;

import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;

import java.util.List;

public interface ICourseService {
    List<Course> findAll();

    Course findById(long id);

    void save(Course course);

    // metodo para realizar la peticion al micro servicio students
    StudentByCourseResponse findStudentsByCourseId(Long courseId);
}
