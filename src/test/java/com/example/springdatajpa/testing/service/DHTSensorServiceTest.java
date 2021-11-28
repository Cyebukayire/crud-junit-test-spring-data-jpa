package com.example.springdatajpa.testing.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

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
		when(dhtSensorRepositoryMock.findAll()).thenReturn(Arrays.asList(
						new DHTSensor(105,23,34,"Kicukiro"), 
						new DHTSensor(105,45,56,"Nyarugenge")
						));
		assertEquals("Kicukiro", dhtSensorService.getAll().get(0).getLocation());
	}
}
