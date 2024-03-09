package com.testdome.excercises.weather.forecast.service.utils;

@FunctionalInterface
public interface TemperatureMeasurementCallback {
	public void temperatureMeasured(int temperature);
}
