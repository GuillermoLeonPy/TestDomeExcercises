package com.testdome.excercises.weather.forecast.service.thermometer;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class FakeThermometer implements Thermometer {

	private int currentTemperature = 21;
	
	@Override
	public int measure() {
		// TODO Auto-generated method stub
		return currentTemperature++;
	}

}
