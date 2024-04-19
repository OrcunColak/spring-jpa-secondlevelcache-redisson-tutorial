package com.colak.springjpasecondlevelcachetutorial.repository;

import com.colak.springjpasecondlevelcachetutorial.jpa.Planet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PlanetRepositoryTest {

    @Autowired
    private PlanetRepository repository;

    @Test
    void findById() {
        Optional<Planet> byId  = repository.findById(1L);
        assertThat(byId).isPresent();

        // Fo L2 hit we need to find by id
        byId = repository.findById(1L);
        assertThat(byId).isPresent();

        Planet planet = byId.get();
        assertThat(planet).isNotNull();
    }

    @Test
    @Transactional
    void findAll() {
        Iterable<Planet> all = repository.findAll();
        assertThat(all).isNotEmpty();

        all = repository.findAll();
        assertThat(all).isNotEmpty();
    }
}
