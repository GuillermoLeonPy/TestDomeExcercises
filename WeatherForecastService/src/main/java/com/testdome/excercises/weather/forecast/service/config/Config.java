package com.testdome.excercises.weather.forecast.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.testdome.excercises.weather.forecast.service.WeatherForecastService;
import com.testdome.excercises.weather.forecast.service.thermometer.FakeThermometer;
import com.testdome.excercises.weather.forecast.service.utils.TemperatureMeasurementCallback;

@Configuration
@Import({FakeThermometer.class, WeatherForecastService.class})
public class Config {

    @Bean
    public TemperatureMeasurementCallback callback() {
        System.out.println("Registering TemperatureMeasurementCallback bean");
        return (temperature) -> System.out.println(temperature);
    }
}
