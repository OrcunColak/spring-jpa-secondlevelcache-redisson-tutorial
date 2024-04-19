package com.colak.springjpasecondlevelcachetutorial.jpa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Set;

@Entity
@Table(name = "planets")
@Cache(region = "planetCache", usage = CacheConcurrencyStrategy.READ_WRITE)

@Getter
@Setter
public class Planet {
    @Id
    private long id;
    private String name;
    private String type;
    private float mass;
    private int diameter;
    private float distance;

    @OneToMany(mappedBy="planet", cascade=CascadeType.ALL)
    private Set<Moon> moons;
}
