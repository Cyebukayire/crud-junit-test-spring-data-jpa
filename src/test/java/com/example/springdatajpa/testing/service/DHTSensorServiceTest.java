package com.example.springdatajpa.testing.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springdatajpa.testing.repository.DHTSensorRepository;

@RunWith(SpringRunner .class)
@DataJpaTest
public class DHTSensorServiceTest {
	
	@Autowired
	DHTSensorRepository dhtSensorRepository;
	
	@Test
	public void getAll_success() {
		
	}
}
