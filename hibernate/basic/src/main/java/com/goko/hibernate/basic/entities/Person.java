package com.goko.hibernate.basic.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "persons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    Person(String name, String homeDirection) {
        this.name = name;
        this.homeDirection = homeDirection;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String lastName;
    
    private int age;
    
    @Column(name = "home_direction")
    private String homeDirection;

    @Embedded
    private AuthDate authDate = new AuthDate();

}
