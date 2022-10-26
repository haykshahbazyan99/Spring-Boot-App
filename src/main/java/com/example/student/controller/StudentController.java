package com.example.student.controller;

import com.example.student.dto.StudentDto;
import com.example.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

//    @Autowired
    private StudentService studentService;


    @GetMapping
    public List<StudentDto> getStudents() {
       return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody StudentDto studentDto) {
        studentService.addNewStudent(studentDto);
    }

    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping("{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam("name") String name,
                              @RequestParam("email") String email) {
        studentService.updateStudent(studentId, name, email);
    }

}
