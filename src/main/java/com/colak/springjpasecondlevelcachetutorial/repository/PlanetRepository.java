package com.colak.springjpasecondlevelcachetutorial.repository;

import com.colak.springjpasecondlevelcachetutorial.jpa.Planet;

public interface PlanetRepository extends QueryCacheCrudRepository<Planet, Long> {
}
