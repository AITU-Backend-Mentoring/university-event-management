package com.em.event_manager.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String venue;
    private LocalDateTime date;
    private String type;
    public Event() {};
    public Event(Long id, String name, String venue, LocalDateTime date, String type) {
        this.id = id;
        this.name = name;
        this.venue = venue;
        this.date = date;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVenue() {
        return venue;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }
}
