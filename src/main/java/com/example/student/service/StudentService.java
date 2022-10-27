package com.example.student.service;

import com.example.student.dto.StudentDto;
import com.example.student.dto.StudentConverter;
import com.example.student.mapper.StudentMapper;
import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentConverter converter;
    @Autowired
    private StudentMapper studentMapper;

    private final RestTemplate restTemplate;

    @Autowired
    public StudentService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


//    public void saveStudent(StudentDto studentDto) {
//        HttpEntity<StudentDto> entity = new HttpEntity<>(studentDto);
//        restTemplate.exchange("http://localhost:8080/students", HttpMethod.POST, entity, void.class).getBody();
//    }


//    public List<Student> getStudents() {
//        return restTemplate.exchange("http://localhost:8080/students", HttpMethod.GET, null, List.class).getBody();
//
//    }

    public List<StudentDto> getStudents() {
        List<Student> allStudents = studentRepository.findAll();
        return converter.entityToDto(allStudents);
    }

    public void addNewStudent(StudentDto studentDto) {

        Student student = converter.dtoToEntity(studentDto);
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("student with email " + student.getEmail() + " is already registered");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if(!exists) {
            throw new IllegalStateException("Student with id " + studentId + " does NOT exist");
        }
        studentRepository.deleteById(studentId);
    }


    public void updateStudent(Long studentId, String name, String email) {

        Student student = studentRepository.findById(studentId).orElseThrow();

        student.setName(name);
        student.setEmail(email);
    }
}
