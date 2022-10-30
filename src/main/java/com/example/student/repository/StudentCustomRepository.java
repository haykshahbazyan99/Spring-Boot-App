package com.example.student.repository;

import com.example.student.model.Student;

import java.util.List;

public interface StudentCustomRepository {

    List<Student> findByNameAndCity(String name, String city);

}
