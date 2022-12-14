package com.example.student.dto;

import com.example.student.model.Student;
import com.example.student.weather.WeatherService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConverter {

    public StudentDto entityToDto(Student student) {

        StudentDto dto = new StudentDto();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setDob(student.getDob());
        dto.setCity(student.getCity());
        dto.setCityTemperature(student.getCityTemperature());


        return dto;
    }

    public List<StudentDto> entityToDto(List<Student> student) {
       return student.stream()
               .map(this::entityToDto)
               .collect(Collectors.toList());
    }

    public Student dtoToEntity(StudentDto dto) {

        Student st =  new Student();

        st.setName(dto.getName());
        st.setEmail(dto.getEmail());
        st.setDob(dto.getDob());
        st.setCity(dto.getCity());

        WeatherService weatherService = new WeatherService();
        double temp = weatherService.getTemp(dto.getCity());

        st.setCityTemperature(temp);

        return st;
    }

    public List<Student> dtoToEntity(List<StudentDto> dto) {
        return dto.stream().
                map(this::dtoToEntity)
                .collect(Collectors.toList());
    }

}
