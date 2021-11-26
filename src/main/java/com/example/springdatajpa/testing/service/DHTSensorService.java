package com.example.springdatajpa.testing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdatajpa.testing.model.DHTSensor;
import com.example.springdatajpa.testing.repository.DHTSensorRepository;

@Service
public class DHTSensorService {
	
	@Autowired
	public DHTSensorRepository dhtSensorRepository;
	
	public List<DHTSensor> getAll(){
		List<DHTSensor> dhtsensors = dhtSensorRepository.findAll();
//		for(DHTSensor dhtsensor:dhtsensors) {
//			dhtsensor.setValue()
//		}
		return dhtsensors;
	}
	
	public List<DHTSesnor> getById() {
		
	}
	
}
