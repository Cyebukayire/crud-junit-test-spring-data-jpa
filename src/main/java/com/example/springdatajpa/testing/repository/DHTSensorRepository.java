package com.example.springdatajpa.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springdatajpa.testing.model.DHTSensor;

@Repository
public interface DHTSensorRepository extends JpaRepository<DHTSensor, Integer> {
	boolean existsByLocation(String Location);
}
