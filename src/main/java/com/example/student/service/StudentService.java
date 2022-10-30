package com.example.student.service;

import com.example.student.dto.StudentDto;
import com.example.student.dto.StudentConverter;
import com.example.student.mapper.StudentMapper;
import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.weather.WeatherService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentConverter converter;
    private final StudentMapper studentMapper;


    public List<StudentDto> getStudents() {
        List<Student> allStudents = studentRepository.findAll();
        return converter.entityToDto(allStudents);
    }

    public void addNewStudent(StudentDto studentDto) {

        Student student = converter.dtoToEntity(studentDto);
        Optional<Student> studentOptional = studentRepository.findByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("student with email " + student.getEmail() + " is already registered");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Integer studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if(!exists) {
            throw new IllegalStateException("Student with id " + studentId + " does NOT exist");
        }
        studentRepository.deleteById(studentId);
    }


    public void updateStudent(Integer studentId, StudentDto studentDto) {

        Student student = studentRepository.findById(studentId).orElseThrow();

        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
    }
}
