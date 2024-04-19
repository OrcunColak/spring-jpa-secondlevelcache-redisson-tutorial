package com.colak.springjpasecondlevelcachetutorial.repository;

import jakarta.persistence.QueryHint;
import org.hibernate.jpa.HibernateHints;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * To enable query cache for a repository see
 * <a href="https://stackoverflow.com/questions/72781063/spring-data-jpa-hibernate-second-level-cache-without-queryhints">...</a>
 * <p>
 * For explanation of @QueryHint see
 * <a href="https://medium.com/jpa-java-persistence-api-guide/how-queryhints-in-spring-data-jpa-can-speed-up-your-applications-a-practical-guide-639d6cacfa0f">...</a>
 */
@NoRepositoryBean
public interface QueryCacheCrudRepository<T, ID> extends CrudRepository<T, ID> {
    @QueryHints({
            // Enables query result caching, reducing database load for repeat queries.
            @QueryHint(name = HibernateHints.HINT_CACHEABLE, value = "true"),
            // Defines the cache region for storing query results, allowing for finer cache strategy tuning.
            @QueryHint(name = HibernateHints.HINT_CACHE_REGION, value = "queryCacheRegion"),
    })
    Iterable<T> findAll();

    @QueryHints({
            // Enables query result caching, reducing database load for repeat queries.
            @QueryHint(name = HibernateHints.HINT_CACHEABLE, value = "true"),
            // Defines the cache region for storing query results, allowing for finer cache strategy tuning.
            @QueryHint(name = HibernateHints.HINT_CACHE_REGION, value = "queryCacheRegion"),
    })
    Iterable<T> findAllById(Iterable<ID> ids);
}
