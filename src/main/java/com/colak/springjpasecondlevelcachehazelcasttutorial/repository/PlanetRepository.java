package com.colak.springjpasecondlevelcachehazelcasttutorial.repository;

import com.colak.springjpasecondlevelcachehazelcasttutorial.jpa.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
}
