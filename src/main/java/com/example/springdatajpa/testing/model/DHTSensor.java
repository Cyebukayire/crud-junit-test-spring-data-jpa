package com.example.springdatajpa.testing.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DHTSensor {
	
public DHTSensor(int id, double d, double e, String location) {
		super();
		this.id = id;
		this.temperature = d;
		this.humidity = e;
		this.location = location;
	}

	public DHTSensor(double temperature, double humidity, String location) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.location = location;
	}
	
	@Id
	private int id;
	private double temperature;
	private double humidity;
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
