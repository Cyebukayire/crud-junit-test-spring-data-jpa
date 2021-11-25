package com.example.springdatajpa.testing.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@TestMethodOrder(MethodOrderer .OrderAnnotation.class)

public class DHTSensorRepositoryTest {
	
	@Autowired
	private DHTSensorRepository dhtSensorRepository;
	
}
