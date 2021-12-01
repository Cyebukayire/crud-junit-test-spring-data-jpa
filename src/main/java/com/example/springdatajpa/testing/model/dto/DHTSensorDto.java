package com.example.springdatajpa.testing.model.dto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class DHTSensorDto {
	
	private float temperature;
	
	private float humidity;
	
	private String location;

	public DHTSensorDto(float temperature, float humidity, String location) {
		super();
		this.temperature = temperature;
		this.humidity = humidity;
		this.location = location;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	

}
