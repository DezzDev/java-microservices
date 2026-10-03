package com.microservice.student.persistence;

import com.microservice.student.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    // jpa detect the method name and create the query automatically
    List<Student> findAllByCourseId(Long idCourse);

    // another way to create  the same method, this way we create a query using JPQL
    // custom query using @Query annotation
    // @Query("SELECT s FROM Student s WHERE s.courseId = :courseId")
    // List<Student> findStudentsByCourseId(Long courseId);

}
