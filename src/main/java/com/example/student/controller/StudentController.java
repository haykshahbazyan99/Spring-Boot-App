package com.example.student.controller;

import com.example.student.dto.StudentDto;
import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping
    public List<StudentDto> getStudents() {
       return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody StudentDto studentDto) {
        studentService.addNewStudent(studentDto);
    }

    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping("{studentId}")
    public void updateStudent(@PathVariable("studentId") Integer studentId,
                              @RequestBody StudentDto studentDto) {
        studentService.updateStudent(studentId, studentDto);
    }


    @GetMapping("{name}/{city}")
    public List<Student> findByNameAndCity(@PathVariable("name") String name,
                                           @PathVariable("city") String city) {
        return studentService.findByNameAndCity(name, city);
    }

}
