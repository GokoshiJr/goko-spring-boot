package com.goko.hibernate.basic.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
    @PrePersist
    public void prePersist() {
        System.out.println("Evento de ciclo de vida pre persist");
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println("Evento de ciclo de vida pre update");
        this.updatedAt = LocalDateTime.now();
    }

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

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    
    @Column(name = "home_direction")
    private String homeDirection;
}
