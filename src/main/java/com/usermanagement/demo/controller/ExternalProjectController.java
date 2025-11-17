package com.usermanagement.demo.controller;

import com.usermanagement.demo.dto.ExternalProjectRequest;
import com.usermanagement.demo.dto.ExternalProjectResponse;
import com.usermanagement.demo.service.ExternalProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users/{userId}/projects")
@RequiredArgsConstructor
public class ExternalProjectController {

    private final ExternalProjectService service;

    @PostMapping
    public ResponseEntity<ExternalProjectResponse> add(
            @PathVariable UUID userId,
            @Valid @RequestBody ExternalProjectRequest req) {
        return ResponseEntity.ok(service.add(userId, req));
    }

    @GetMapping
    public ResponseEntity<List<ExternalProjectResponse>> list(@PathVariable UUID userId) {
        return ResponseEntity.ok(service.list(userId));
    }
}
