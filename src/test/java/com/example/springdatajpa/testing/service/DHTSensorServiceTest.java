package com.example.springdatajpa.testing.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.academic.realassetmis.utils.Exceptions.ResourceNotFoundException;
import com.example.springdatajpa.testing.model.DHTSensor;
import com.example.springdatajpa.testing.repository.DHTSensorRepository;

@RunWith(SpringRunner .class)
public class DHTSensorServiceTest {
	
	@Mock
	DHTSensorRepository dhtSensorRepositoryMock;
	
	@InjectMocks
	DHTSensorService dhtSensorService;
	
	@Test
	public void getAll_success() {
		when(dhtSensorRepositoryMock.findAll()).thenReturn(
				Arrays.asList(
						new DHTSensor(105,23,34,"Kicukiro"), 
						new DHTSensor(105,45,56,"Nyarugenge")
						)
				);
		assertEquals("Kicukiro", dhtSensorService.getAll().get(0).getLocation());
	}
	
	@Test
	public void getOne_success() {
		when(dhtSensorRepositoryMock.findById(106)).thenReturn(
				Optional.of(new DHTSensor(106,23,30,"Karongi")
						));
		assertEquals(23, dhtSensorRepositoryMock.findById(106).get().getTemperature(), 0);
	}
	
//	@Test()
//	public void getOne_notFound() {
//		
//	}
	
	@Test
	public void save_success() {
		DHTSensor dhtsensor = new DHTSensor(105, 54,43,"Rusizi");
		when(dhtSensorRepositoryMock.save(dhtsensor)).thenReturn(dhtsensor);
		assertEquals(43, dhtSensorRepositoryMock.findById(101).get().getHumidity(), 0);
		
	}
	
	
}