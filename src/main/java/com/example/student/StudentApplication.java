package com.example.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {

//		RestTemplate restTemplate = new RestTemplate();
//		String url = "https://api.openweathermap.org/data/2.5/weather?q=yerevan&units=metric&APPID=88fe9edff1c38f614e49bbc96d853729";
//		WeatherService response = restTemplate.getForObject(url, WeatherService.class);
//
//
//		System.out.println(response.getMain().getTemp());


		SpringApplication.run(StudentApplication.class, args);
	}


}
