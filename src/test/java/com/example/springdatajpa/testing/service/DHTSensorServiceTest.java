package com.example.springdatajpa.testing.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springdatajpa.testing.model.DHTSensor;
import com.example.springdatajpa.testing.model.dto.DHTSensorDto;
import com.example.springdatajpa.testing.repository.DHTSensorRepository;

import static org.mockito.ArgumentMatchers.any;

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
		assertEquals(23, dhtSensorService.getById(106).getTemperature(), 0);
	}
	
//	@Test()
//	public void getOne_notFound() {
//		
//	}
	
	@Test
	public void save_success() {
		DHTSensorDto dto = new DHTSensorDto(54,43,"Rusizi");
		DHTSensor dhtsensor = new DHTSensor(105,54,43,"Rusizi");
		when(dhtSensorRepositoryMock.save(any(DHTSensor.class))).thenReturn(dhtsensor);
		assertEquals(43, dhtSensorService.create(dto).getHumidity(), 0);
		
	}
	
	@Test
	public void update_success() {
		DHTSensorDto dto = new DHTSensorDto(54,87,"Ruhango");
		DHTSensor dhtsensor = new DHTSensor(101,43,76,"Muhanga");
		when(dhtSensorRepositoryMock.findById(101)).thenReturn(Optional.of(dhtsensor));
		when(dhtSensorRepositoryMock.save(dhtsensor)).thenReturn(dhtsensor);
		DHTSensor updateDhtSensor = dhtSensorService.update(dhtsensor.getId(), dto);
		assertEquals("Ruhango", updateDhtSensor.getLocation());		
	}
	
	@Test
	public void deleteById_success() {
		DHTSensor dhtsensor = new DHTSensor(105,43,54,"Kayonza");
		when(dhtSensorRepositoryMock.findById(105)).thenReturn(Optional.of(dhtsensor));
		when(dhtSensorRepositoryMock.save(dhtsensor)).thenReturn(dhtsensor);
		dhtSensorService.deleteDhtsensor(dhtsensor.getId());
		verify(dhtSensorRepositoryMock).deleteById(dhtsensor.getId());
	}
	
	
}