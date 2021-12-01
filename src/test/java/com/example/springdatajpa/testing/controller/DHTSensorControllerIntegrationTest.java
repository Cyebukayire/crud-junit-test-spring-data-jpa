package com.example.springdatajpa.testing.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DHTSensorControllerIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void getAll_success() throws JSONException{
		String response = this.restTemplate.getForObject("/all-dhtsensors", String.class);
		System.out.println(response);
		JSONAssert.assertEquals("[{id:101}, {id:102}, {id:103}, {id:104}]", response, false);
	}

//	@Test
//	public void getById_successEntity() throws JSONException{
//		ResponseEntity<DHTSensor> response = this.restTemplate.getForEntity("all-dhtsensors/101",DHTSensor)
//	}
//	
//	@Test
//	public void createDhtsensor_success {
//		updateDhtsensor dhtsensor = new updateDhtsensor()
//	}
//	
}
