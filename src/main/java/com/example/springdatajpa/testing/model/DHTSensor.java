package com.example.springdatajpa.testing.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DHTSensor {
	
public DHTSensor(int id, float temperature, float humidity, String location) {
		super();
		this.id = id;
		this.temperature = temperature;
		this.humidity = humidity;
		this.location = location;
	}

	public DHTSensor(float temperature, float humidity, String location) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.location = location;
	}
	
	@Id
	private int id;
	private float temperature;
	private float humidity;
	private String location;
	
	public DHTSensor() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
