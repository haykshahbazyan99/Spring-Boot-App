package com.example.student.service;

import com.example.student.dto.StudentDto;
import com.example.student.dto.StudentDtoConverter;
import com.example.student.mapper.StudentMapper;
import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentDtoConverter converter;

    @Autowired
    private StudentMapper studentMapper;


    public List<StudentDto> getStudents() {
        List<Student> allStudents = studentRepository.findAll();
        return studentMapper.toStudentDtos(allStudents);
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
