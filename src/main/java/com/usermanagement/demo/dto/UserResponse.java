package com.usermanagement.demo.dto;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String email,
        String name
) {
}
