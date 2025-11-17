package com.usermanagement.demo.service;

import com.usermanagement.demo.dto.ExternalProjectRequest;
import com.usermanagement.demo.dto.ExternalProjectResponse;
import com.usermanagement.demo.entity.ExternalProject;
import com.usermanagement.demo.entity.User;
import com.usermanagement.demo.repository.ExternalProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExternalProjectService {

    private final ExternalProjectRepository repository;
    private final UserService userService;

    public ExternalProjectResponse add(UUID userId, ExternalProjectRequest req) {
        User user = userService.getEntity(userId);

        ExternalProject p = ExternalProject.builder()
                .name(req.name())
                .user(user)
                .build();

        repository.save(p);

        return new ExternalProjectResponse(p.getId(), p.getName());
    }

    public List<com.usermanagement.demo.dto.ExternalProjectResponse> list(UUID userId) {
        User user = userService.getEntity(userId);

        return user.getProjects().stream()
                .map(p -> new ExternalProjectResponse(p.getId(), p.getName()))
                .toList();
    }
}
