package com.example.student.weather;

import org.springframework.web.client.RestTemplate;

public class WeatherService {

    public double getTemp(String city) {


        RestTemplate restTemplate = new RestTemplate();

        //Universities
        //http://universities.hipolabs.com/search?name=Yerevan%20State%20Medical%20University

        String url = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&APPID=88fe9edff1c38f614e49bbc96d853729", city);

        WeatherDetails response = restTemplate.getForObject(url, WeatherDetails.class);

        return response.getMain().getTemp();
    }

}
