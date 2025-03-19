package com.em.event_manager.service;

import com.em.event_manager.models.Event;
import com.em.event_manager.models.Preregistration;
import com.em.event_manager.models.RegistrationStatus;
import com.em.event_manager.models.User;
import com.em.event_manager.repository.EventRepository;
import com.em.event_manager.repository.PreregistrationRepository;
import com.em.event_manager.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PreregistrationService {

    private PreregistrationRepository preregistrationRepository;
    private EventRepository eventRepository;
    private UserRepo userRepository;

    @Autowired
    public PreregistrationService(PreregistrationRepository preregistrationRepository,EventRepository eventRepository,UserRepo userRepository) {
        this.preregistrationRepository = preregistrationRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public String preregister(Long eventId, Long userId) {
        if (preregistrationRepository.existsByEventIdAndUserId(eventId, userId)) {
            return "You are already preregistered for this event!";
        }

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Preregistration preregistration = new Preregistration();
        preregistration.setEvent(event);
        preregistration.setUser(user);
        preregistration.setRegisteredAt(LocalDateTime.now());

        Preregistration saved=preregistrationRepository.save(preregistration);
        if (saved.getId() != null) {
            return "Preregistration successful!";
        }
        return "Preregistration failed. Please try again.";
    }

    public String approveRegistration(Long preregistrationId, RegistrationStatus registrationStatus) {
        Preregistration preregistration = preregistrationRepository.findById(preregistrationId)
                .orElseThrow(() -> new RuntimeException("Preregistration not found"));
        preregistration.setStatus(registrationStatus);
        Preregistration saved=preregistrationRepository.save(preregistration);
        if (saved.getStatus()==registrationStatus) {
            return "Preregistration status was successfully changed!";
        }
        return "Preregistration status failed to change. Please try again.";
    }
}

