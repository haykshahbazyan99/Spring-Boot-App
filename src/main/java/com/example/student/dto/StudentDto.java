package com.example.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private int id;
    private String name;
    private String email;
    private LocalDate dob;
    private String city;
    private double cityTemperature;

}
