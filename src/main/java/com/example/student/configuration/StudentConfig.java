package com.example.student.configuration;

import com.example.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class StudentConfig implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {

        Student mariam = new Student("Mariam", "mariamik@gmail.com", LocalDate.of(2000, Month.FEBRUARY, 5), "Yerevan", 4);
        restTemplate.exchange("http://localhost:8080/students", HttpMethod.POST,  new HttpEntity<>(mariam), Void.class);
    }

}
