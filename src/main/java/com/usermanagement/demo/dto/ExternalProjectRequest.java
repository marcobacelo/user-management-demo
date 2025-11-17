package com.usermanagement.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record ExternalProjectRequest(
        @NotBlank(message = "Nome do projeto obrigatório")
        String name
) {
}
