package com.example.springdatajpa.testing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdatajpa.testing.model.DHTSensor;
import com.example.springdatajpa.testing.repository.DHTSensorRepository;

@RestController
public class DHTSensorController {
	
	@Autowired
	private DHTSensorRepository dhtSensorRepositry;
	
//	@GetMapping("/all-items")
//	public List<DHTSensor> getAll(){
//		return dhtSensorRepositry.getAll();
//	}
	
	
	
	
	
}
