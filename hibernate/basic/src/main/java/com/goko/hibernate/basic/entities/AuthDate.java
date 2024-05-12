package com.goko.hibernate.basic.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

@Embeddable
@Data
public class AuthDate {
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

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
}
