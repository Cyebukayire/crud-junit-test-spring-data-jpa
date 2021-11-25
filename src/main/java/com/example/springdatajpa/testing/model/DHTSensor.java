package com.example.springdatajpa.testing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "DHTSensor")
public class DHTSensor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "temperature", nullable = false)
	private String temperature;
	
	@Column(name = "humidity", nullable = false)
	private String humidity;

}
