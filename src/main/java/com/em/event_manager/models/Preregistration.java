package com.em.event_manager.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Preregistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    private LocalDateTime registeredAt = LocalDateTime.now();

    private LocalDateTime eventDate;

    @Enumerated(EnumType.STRING)
    private RegistrationStatus status = RegistrationStatus.PENDING;


    @PrePersist
    public void setEventDateBeforeSaving() {
        this.eventDate = event.getDate();
    }

    public void setEvent(Event event) {
        this.event = event;
        if (event != null) {
            this.eventDate = event.getDate();
        }
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRegisteredAt(LocalDateTime now) {
        registeredAt = now;
    }
    public Long getId() {
        return id;
    }
    public void setStatus(RegistrationStatus status) {
        this.status = status;
    }
    public RegistrationStatus getStatus() {
        return status;
    }
}

