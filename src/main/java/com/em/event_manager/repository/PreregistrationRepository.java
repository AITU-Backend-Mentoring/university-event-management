package com.em.event_manager.repository;

import com.em.event_manager.models.Preregistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreregistrationRepository extends JpaRepository<Preregistration, Long> {
    List<Preregistration> findByEventId(Long eventId);
    boolean existsByEventIdAndUserId(Long eventId, Long userId);
}

