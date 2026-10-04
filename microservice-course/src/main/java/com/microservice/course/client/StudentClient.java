package com.microservice.course.client;

import com.microservice.course.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// este client es para poder hacerle peticiones al microservice student
// nombre del microservicio que sera consultado
@FeignClient(name= "msvc-student",url = "localhost:8090/api/student")
public interface StudentClient {
    @GetMapping("search-by-course/{idCourse}")
    List<StudentDto> getAllStudentsByCourse(@PathVariable Long idCourse );
}
