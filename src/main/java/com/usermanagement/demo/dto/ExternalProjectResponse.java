package com.usermanagement.demo.dto;

import java.util.UUID;

public record ExternalProjectResponse(
        UUID id,
        String name
) {
}
