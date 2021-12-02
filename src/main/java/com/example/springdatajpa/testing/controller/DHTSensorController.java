package com.example.springdatajpa.testing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdatajpa.testing.model.DHTSensor;
import com.example.springdatajpa.testing.model.dto.DHTSensorDto;
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
	
	@PostMapping("/all-dhtsensors/save")
	public ResponseEntity<?> saveDhtsensor(@RequestBody DHTSensorDto dto) {
		if(dhtsensorService.existsByLocation(dto.getLocation())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dhtsensor already exists");
		}
		DHTSensor dhtsensor = dhtsensorService.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(dhtsensor);		
	}
	
	@PutMapping("/all-dhtsensors/update/{id}")
	public ResponseEntity<?> updateDhtsensor(@PathVariable(name = "id") int id, @RequestBody DHTSensorDto dto) {
		DHTSensor dhtsensor = dhtsensorService.getById(id);
		if(dhtsensor != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(dhtsensor);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIResponse(false, "Dhtsensor does not exist"));
	}
	
	@DeleteMapping("/all-dhtsensors/delete/{id}")
	public ResponseEntity<?> deleteDhtsensor(@PathVariable(name = "id") int id){
		DHTSensor dhtsensor = dhtsensorService.deleteDhtsensor(id);
		return ResponseEntity.ok(dhtsensor);
	}	
	
}
