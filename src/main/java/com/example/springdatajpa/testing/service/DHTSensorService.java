package com.example.springdatajpa.testing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdatajpa.testing.model.DHTSensor;
import com.example.springdatajpa.testing.model.dto.DHTSensorDto;
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
	
	public DHTSensor create(DHTSensorDto dto) {
		DHTSensor dhtsensor = new DHTSensor();
				dhtsensor.setTemperature(dto.getTemperature());
				dhtsensor.setHumidity(dto.getHumidity());
				dhtsensor.setLocation(dto.getLocation());
				
		return dhtSensorRepository.save(dhtsensor);
	}

	public DHTSensor update(int id, DHTSensorDto dto){
		Optional<DHTSensor> dhtsensorExists = dhtSensorRepository.findById(id);
		if(dhtsensorExists.isPresent()) {
			DHTSensor dhtsensor = dhtsensorExists.get();
			dhtsensor.setId(id);
			dhtsensor.setTemperature(dto.getTemperature());
			dhtsensor.setHumidity(dto.getHumidity());
			dhtsensor.setLocation(dto.getLocation());
			
			return dhtSensorRepository.save(dhtsensor);
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
	
	public DHTSensor deleteDhtsensor(int id) {
		Optional<DHTSensor> dhtsensorExists = dhtSensorRepository.findById(id);
		if(dhtsensorExists.isPresent()) {
			dhtSensorRepository.deleteById(id);
		}
		return null;
	}

	public boolean existsByLocation(String location) {
		return dhtSensorRepository.existsByLocation(location);
	}
}
