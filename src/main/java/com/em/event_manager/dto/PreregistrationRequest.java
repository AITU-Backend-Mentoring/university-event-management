package com.em.event_manager.dto;

public class PreregistrationRequest {
    private Long eventId;
    private Long userId;

    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
