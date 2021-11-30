package com.example.springdatajpa.testing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdatajpa.testing.model.DHTSensor;
import com.example.springdatajpa.testing.service.DHTSensorService;
import com.example.springdatajpa.testing.utils.APIResponse;

@RestController
public class DHTSensorController {
	
	@Autowired
	private DHTSensorService dhtsensorService;
	
	@GetMapping("/all-dhtsensors")
	public List<DHTSensor> getAll(){
		return dhtsensorService.getAll();
	}
	
	@GetMapping("/all-dhtsensors/{id}")
	public ResponseEntity<?>  getById(@PathVariable(name = "id") int id){
		DHTSensor dhtsensor = dhtsensorService.getById(id);
		if(dhtsensor != null) {
			return ResponseEntity.ok(dhtsensor);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIResponse(false, "Dhtsensor not found"));
	}
	
//	@GetMapping("/")
	
	
	
	
}
