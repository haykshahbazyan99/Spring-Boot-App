package com.example.student.mapper;

import com.example.student.dto.StudentDto;
import com.example.student.model.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDto toStudentDto(Student student);

    List<StudentDto> toStudentDtos(List<Student> students);

    Student toDtoStudent(StudentDto studentDto);
}
