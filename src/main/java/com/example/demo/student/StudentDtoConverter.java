package com.example.demo.student;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentDtoConverter {

    public StudentDto entityToDto(Student student) {

        StudentDto dto = new StudentDto();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());

        return dto;
    }

    public List<StudentDto> entityToDto(List<Student> student) {
       return student.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public Student dtoToEntity(StudentDto dto) {
        Student st =  new Student();
        st.setId(dto.getId());
        st.setName(dto.getName());
        st.setEmail(dto.getEmail());

        return st;
    }

    public List<Student> dtoToEntity(List<StudentDto> dto) {
        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
