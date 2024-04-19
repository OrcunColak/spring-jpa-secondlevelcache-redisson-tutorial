package com.colak.springjpasecondlevelcachetutorial.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "moons")

@Getter
@Setter
public class Moon {
    @Id
    private long id;

    private String name;

    private int diameter;

    @ManyToOne
    @JoinColumn(name="planet_id", nullable=false)
    private Planet planet;

    @Override
    public String toString() {
        return "Moon{" +
               "id=" + id +
               ", planet=" + planet.getName() +
               ", name='" + name + '\'' +
               ", diameter=" + diameter +
               '}';
    }
}