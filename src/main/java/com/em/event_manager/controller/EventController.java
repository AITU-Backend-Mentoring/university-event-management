package com.em.event_manager.controller;

import com.em.event_manager.models.Event;
import com.em.event_manager.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/event")
public class EventController {
    private final EventService eventService;
    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping
    public List<Event> getAllEvents(@RequestParam (required=false) String name,
                                    @RequestParam (required=false) String venue,
                                    @RequestParam (required = false) String type,
                                    @RequestParam (required = false)LocalDateTime time,
                                    @RequestParam (required = false)Long id)  {
        if(name!=null) {
            return eventService.getEventByName(name);
        }
        else if(venue!=null) {
            return eventService.getEventByVenue(venue);
        }else if(type!=null) {
            return eventService.getEventByType(type);
        }else if(type!=null){
            return eventService.getEventByType(type);
        }
        else if(time!=null) {
           return  eventService.getEventByDate(time);
        } else if(id !=null) {
            return eventService.getEventById(id);
        }else{
            return eventService.getAllEvents();
        }
    }
    @PostMapping
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        Event createdEvent = eventService.addEvent(event);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
        Event updatedEvent = eventService.updateEvent(event);
        if (updatedEvent != null) {
            return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{event_id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long event_id) {
        eventService.deleteEvent(event_id);
        return new ResponseEntity<>("Event was deleted", HttpStatus.OK);
    }


}
