package com.techMall.api.models.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryDTO(Long id, @NotBlank String categoryName) {
}