package com.usermanagement.demo.repository;

import com.usermanagement.demo.entity.ExternalProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExternalProjectRepository extends JpaRepository<ExternalProject, UUID> {
}
