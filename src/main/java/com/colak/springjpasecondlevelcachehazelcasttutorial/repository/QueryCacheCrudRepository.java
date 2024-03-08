package com.colak.springjpasecondlevelcachehazelcasttutorial.repository;

import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * See <a href="https://stackoverflow.com/questions/72781063/spring-data-jpa-hibernate-second-level-cache-without-queryhints">...</a>
 */
@NoRepositoryBean
public interface QueryCacheCrudRepository<T, ID> extends CrudRepository<T, ID> {
    @QueryHints({
            @QueryHint(name = "org.hibernate.cacheable", value = "true")
    })
    Iterable<T> findAll();

    @QueryHints({
            @QueryHint(name = "org.hibernate.cacheable", value = "true")
    })
    Iterable<T> findAllById(Iterable<ID> ids);
}
