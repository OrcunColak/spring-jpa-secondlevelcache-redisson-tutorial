package com.colak.springjpasecondlevelcachehazelcasttutorial.repository;

import com.colak.springjpasecondlevelcachehazelcasttutorial.jpa.Planet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PlanetRepositoryTest {

    @Autowired
    private PlanetRepository repository;

    @Test
    void findAll() {
        List<Planet> all = repository.findAll();
        assertThat(all).isNotEmpty();

        // Fo L2 hit we need to find by id
        Optional<Planet> byId = repository.findById(1L);
        assertThat(byId).isPresent();

        Planet planet = byId.get();
        assertThat(planet).isNotNull();
    }
}
