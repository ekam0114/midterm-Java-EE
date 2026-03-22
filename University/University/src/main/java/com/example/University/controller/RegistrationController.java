package com.example.University.controller;


import com.example.University.dto.RegistrationResponseDTO;
import com.example.University.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/api/v1/workshops/{id}/registrations")
    public ResponseEntity<RegistrationResponseDTO> register(@PathVariable Long id, @RequestParam String email) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(registrationService.registerUserForWorkshop(id, email));
    }

    @DeleteMapping("/api/v1/registrations/{registrationId}")
    public ResponseEntity<RegistrationResponseDTO> cancelRegistration(
            @PathVariable Long registrationId,
            @RequestParam String email,
            @RequestParam(defaultValue = "false") boolean isAdmin) {
        return ResponseEntity.ok(registrationService.cancelRegistration(registrationId, email, isAdmin));
    }

    @GetMapping("/api/v1/me/registrations")
    public ResponseEntity<List<RegistrationResponseDTO>> getMyRegistrations(@RequestParam String email) {
        return ResponseEntity.ok(registrationService.getMyRegistrations(email));
    }
}
