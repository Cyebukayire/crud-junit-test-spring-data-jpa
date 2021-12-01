package com.example.springdatajpa.testing.model.dto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class DHTSensorDto {
	
	private double temperature;
	
	private double humidity;
	
	private String location;

	public DHTSensorDto(double temperature, double humidity, String location) {
		super();
		this.temperature = temperature;
		this.humidity = humidity;
		this.location = location;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
