package com.em.event_manager.service;

import com.em.event_manager.models.Event;
import com.em.event_manager.repository.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EventService {
    private final EventRepository eventRepository;
    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
    public List<Event> getEventById(Long id) {
        return eventRepository.findAll().stream().filter(event->event.getId().equals(id)).collect(Collectors.toList());

    }
   public List<Event> getEventByType(String searchText) {
       return eventRepository.findAll().stream().filter(event->event.getType().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toList());
    }
    public List<Event> getEventByVenue(String searchText) {
        return eventRepository.findAll().stream().filter(event->event.getVenue().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toList());
    }
    public List<Event> getEventByDate(LocalDateTime date) {
        return eventRepository.findAll().stream().filter(event->event.getDate().equals(date)).collect(Collectors.toList());
    }
    public List<Event> getEventByName(String searchText) {
        return eventRepository.findAll().stream().filter(event->event.getName().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toList());
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }
    public Event updateEvent( Event updatedEvent) {
        Optional<Event> existingEvent = eventRepository.findById(updatedEvent.getId());
        if (existingEvent.isPresent()) {
            Event eventToUpdate = existingEvent.get();
            eventToUpdate.setName(updatedEvent.getName());
            eventToUpdate.setDate(updatedEvent.getDate());
            eventToUpdate.setVenue(updatedEvent.getVenue());
            eventToUpdate.setType(updatedEvent.getType());
            eventRepository.save(eventToUpdate);
            return eventToUpdate;
        }
        return null;
    }
    @Transactional
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}

