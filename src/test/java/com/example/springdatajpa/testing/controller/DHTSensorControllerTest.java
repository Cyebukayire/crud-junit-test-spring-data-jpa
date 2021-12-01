package com.example.springdatajpa.testing.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.springdatajpa.testing.model.DHTSensor;
import com.example.springdatajpa.testing.service.DHTSensorService;

@RunWith(SpringRunner.class)
@WebMvcTest(DHTSensorController.class)
public class DHTSensorControllerTest {
	
	@MockBean
	private DHTSensorService dhtsensorServiceMock;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getAll_success() throws Exception {
		List<DHTSensor> dhtsensors = Arrays.asList(
				new DHTSensor(105,34,45,"Karongi"),
				new DHTSensor(106,89,89,"Rusizi")
				);	
		when(dhtsensorServiceMock.getAll()).thenReturn(dhtsensors);
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.get("/all-dhtsensors")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc
				.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"id\":105,\"temperature\":34.0,\"humidity\":45.0,\"location\":\"Karongi\"},{\"id\":106,\"temperature\":89.0,\"humidity\":89.0,\"location\":\"Rusizi\"}]"))
                .andReturn();
		System.out.println(result);
		
	}
	
//	@Test
//	public void getOne_success() {
//		Optional<DHTSensor> dhtsensor = dhtsensorService.
//	}

}
