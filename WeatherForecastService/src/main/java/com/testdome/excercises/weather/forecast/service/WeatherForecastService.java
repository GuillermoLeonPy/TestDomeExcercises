package com.testdome.excercises.weather.forecast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.testdome.excercises.weather.forecast.service.thermometer.Thermometer;
import com.testdome.excercises.weather.forecast.service.utils.TemperatureMeasurementCallback;

import jakarta.annotation.PostConstruct;

@Service
@EnableScheduling
public class WeatherForecastService {
	
    @Autowired
    private Thermometer thermometer;
    @Autowired
    private TemperatureMeasurementCallback callback;
    
    @PostConstruct
    private void postConstruct() {
    	System.out.println("WeatherForecastService postConstruct");
    }
    
    @Scheduled(fixedRate = 1000)
    public void takeTemperatureMeasurement() {
        int temperature = thermometer.measure();
        callback.temperatureMeasured(temperature);
    }   
}
