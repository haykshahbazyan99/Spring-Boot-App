package com.example.student.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
@NoArgsConstructor
@ConfigurationProperties("my")
@Table(name = "REGISTERED_STUDENTS")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;
    private String city;

    @Column(name = "city_temperature")
    private double cityTemperature;



    public Student(String name, String email, LocalDate dob, String city, double cityTemperature) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.city = city;
        this.cityTemperature = cityTemperature;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
}
