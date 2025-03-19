package com.em.event_manager.controller;

import com.em.event_manager.dto.ApproveRequest;
import com.em.event_manager.dto.PreregistrationRequest;
import com.em.event_manager.models.Preregistration;
import com.em.event_manager.service.PreregistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/preregistration")
public class PreregistrationController {

    private PreregistrationService preregistrationService;
    @Autowired
    public PreregistrationController(PreregistrationService preregistrationService) {
        this.preregistrationService = preregistrationService;
    }

    @PostMapping("/preregister")
    public ResponseEntity<String> preregister(@RequestBody PreregistrationRequest request) {
        String response = preregistrationService.preregister(request.getEventId(), request.getUserId());
        return ResponseEntity.ok(response);
    }
    @PutMapping("admin/approve")
    public ResponseEntity<String> approveRegistration(@RequestBody ApproveRequest request) {
        String response = preregistrationService.approveRegistration(request.getPreregistrationId(), request.getStatus());
        return ResponseEntity.ok(response);
    }
}

