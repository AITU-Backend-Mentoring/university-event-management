package com.em.event_manager.dto;

import com.em.event_manager.models.RegistrationStatus;

public class ApproveRequest {
    private Long preregistrationId;
    private RegistrationStatus status;

    public Long getPreregistrationId() {
        return preregistrationId;
    }

    public void setPreregistrationId(Long preregistrationId) {
        this.preregistrationId = preregistrationId;
    }

    public RegistrationStatus getStatus() {
        return status;
    }

    public void setStatus(RegistrationStatus status) {
        this.status = status;
    }
}
