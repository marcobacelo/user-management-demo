package com.usermanagement.demo.dto;

public record UpdateUserRequest(
        String name,
        String email
) {
}
