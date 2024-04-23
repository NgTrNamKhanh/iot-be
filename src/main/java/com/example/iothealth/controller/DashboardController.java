package com.example.iothealth.controller;

import com.example.iothealth.service.AuthService;
import com.example.iothealth.service.HealthObjectiveService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dashboard")
public class DashboardController {
    private final AuthService authService;
    private final HealthObjectiveService healthObjectiveService;

    // First dashboard, showing the health objectives and the number of users who have selected them in the organisation
    @GetMapping("/health-objectives")
    @PreAuthorize("hasAuthority('manager')")
    public ResponseEntity<?> getHealthObjectives() {
        try {
            UUID userId = authService.getCurrentAuthenticatedUser().getId();
            System.out.println("User ID: " + userId);
            return ResponseEntity.ok(healthObjectiveService.getHealthObjectiveData(userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
