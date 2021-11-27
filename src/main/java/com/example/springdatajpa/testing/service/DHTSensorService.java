package com.example.springdatajpa.testing.service;

import java.util.List;
import java.util.Optional;

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
	
	public DHTSensor getById(int id) {
		Optional<DHTSensor> dhtsensor = dhtSensorRepository.findById(id);
		if(dhtsensor.isPresent()) {
			return dhtsensor.get();
		}
		return null;
	}
	
	public boolean deleteAll() {
		List<DHTSensor> dhtsensors = dhtSensorRepository.findAll();
		if(dhtsensors.size()!=0) {
			dhtSensorRepository.deleteAll();
			return true;
		}
		return false;
	}
	
	public void deleteById(int id) {
		dhtSensorRepository.deleteById(id);
	}
	
	public void save() {
		DHTSensor dhtsensor = new DHTSensor(105,29,44,"Nyarugenge");
		dhtSensorRepository.save(dhtsensor);
	}
	
}
