package com.microservice.course.services;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDto;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.persistence.ICourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

    private final ICourseRepository courseRepository;
    private final StudentClient studentClient;

    public CourseServiceImpl(ICourseRepository courseRepository,  StudentClient studentClient) {
        this.courseRepository = courseRepository;
        this.studentClient = studentClient;
    }



    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentsByCourseId(Long courseId) {
        // consultar el course
        Course course = courseRepository.findById(courseId).orElse(new Course());
        // Obtener los estudiantes
        // para poder consultar el microservice de estudiantes hay que utilizar el cliente
        List<StudentDto> studentDtoList = studentClient.getAllStudentsByCourse(courseId);

        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDtoList)
                .build();

    }
}
