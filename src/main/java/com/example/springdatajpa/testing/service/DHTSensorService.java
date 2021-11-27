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
		return dhtSensorRepository.findAll();
	}
	
	public DHTSensor getById(int id) {
		Optional<DHTSensor> dhtsensor = dhtSensorRepository.findById(id);
		if(dhtsensor.isPresent()) {
			return dhtsensor.get();
		}
		return null;
	}
	
	public String deleteAll() {
		List<DHTSensor> dhtsensors = dhtSensorRepository.findAll();
		if(dhtsensors.size()!=0) {
			dhtSensorRepository.deleteAll();
			return "deleted successfully";
		}
		return null;
	}
	
	public String deleteById(int id) {
		Optional<DHTSensor> dhtsensor = dhtSensorRepository.findById(id);
		if(dhtsensor.isPresent()) {
			dhtSensorRepository.deleteById(id);
			return "deleted successfully";
		}else if(!(dhtsensor.isPresent())) {
			return "not found";
		}
		return null;
	}
	
	public void create(DHTSensor dhtsensor) {
		DHTSensor new_dhtsensor = new DHTSensor(
				dhtsensor.getId(),
				dhtsensor.getTemperature(),
				dhtsensor.getHumidity(),
				dhtsensor.getLocation()
				);
		dhtSensorRepository.save(new_dhtsensor);
	}
	
	public boolean existsByLocation(String location) {
		return dhtSensorRepository.existsByLocation(location);
	}	
}
