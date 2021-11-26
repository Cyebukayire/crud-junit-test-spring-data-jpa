package com.example.springdatajpa.testing.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springdatajpa.testing.model.DHTSensor;

@RunWith(SpringRunner .class)
@DataJpaTest
public class DHTSensorRepositoryTest {
	
	@Autowired
	private DHTSensorRepository dhtSensorRepository;
	
	@Test
	public void findAll_success() {
		List<DHTSensor> dhtsensors = dhtSensorRepository.findAll(); 
		assertTrue(dhtsensors.size()==4);
	}
	
	@Test
	public void findAll_fail() {
		List<DHTSensor> dhtsensors = dhtSensorRepository.findAll();
		assertFalse(dhtsensors.size()==3);
	}
	
	@Test
	public void findOne_success() {
		Optional<DHTSensor> dhtsensor = dhtSensorRepository.findById(101);	
		assertTrue(dhtsensor.isPresent());
	}
	
	@Test 
	public void findOne_fail() {
		Optional<DHTSensor> dhtsensor = dhtSensorRepository.findById(233);
		assertFalse(dhtsensor.isPresent());
	}
	
	@Test
	public void saveOne_success() {
		DHTSensor new_dhtsensor = new DHTSensor(105, 25, 50, "Gasabo");
		DHTSensor saved_dhtsensor = dhtSensorRepository.save(new_dhtsensor);
		assertNotNull(saved_dhtsensor.getId());
		
//		Optional<DHTSensor> saved_dhtsensor = dhtSensorRepository.findById(105);
//		assertTrue(saved_dhtsensor.isPresent());
	}
	
//	@Test
//	public void saveOne_fail() {
//		DHTSensor new_dhtsensor = new DHTSensor(101, 25, 50, "Nyabihu");
//		DHTSensor saved_dhtsensor = dhtSensorRepository.save(new_dhtsensor);
//		assertNull(saved_dhtsensor.getId());
//	}
	
//	@Test 
//	public void saveMany_success() {
//		List<DHTSensor> new_dhtsensors = 
//	}
	
	@Test
	public void deleteOne_success() {
		dhtSensorRepository.deleteById(101);
		List<DHTSensor> dhtsensors = dhtSensorRepository.findAll();
		assertTrue(dhtsensors.size()==3);		
	} 
	
	@Test
	public void deleteOne_fail() {
		Optional<DHTSensor> dhtsensor = dhtSensorRepository.findById(129);
		if(dhtsensor.isPresent()) {
			dhtSensorRepository.deleteById(129);
		}
		assertFalse(dhtsensor.isPresent());				
	}
	
	@Test 
	public void deleteAll_success() {
		dhtSensorRepository.deleteAll();
		List<DHTSensor> dhtsensors = dhtSensorRepository.findAll();
		assertTrue(dhtsensors.size()==0);
	}
	
//	@Test
//	public void deleteAll_fail() {
//		dhtSensorRepository.deleteAll();
//		List<DHTSensor> dhtsensors = dhtSensorRepository.findAll();
//		assertFalse(dhtsensors.size()==0);
// 	}	
	
}
