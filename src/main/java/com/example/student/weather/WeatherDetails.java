package com.example.student.weather;

public class WeatherDetails {

    private String base;
    private MainTemp main;


    public MainTemp getMain() {
        return main;
    }

    public void setMain(MainTemp main) {
        this.main = main;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }


}
