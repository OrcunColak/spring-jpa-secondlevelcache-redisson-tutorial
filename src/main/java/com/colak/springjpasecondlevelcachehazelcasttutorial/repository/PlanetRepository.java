package com.colak.springjpasecondlevelcachehazelcasttutorial.repository;

import com.colak.springjpasecondlevelcachehazelcasttutorial.jpa.Planet;

public interface PlanetRepository extends QueryCacheCrudRepository<Planet, Long> {
}
