package com.techMall.api.models.dto;

import jakarta.validation.constraints.NotBlank;

public record ProductDTO(Long id, @NotBlank String name, @NotBlank String description, @NotBlank Integer stockQuantity, @NotBlank Double price, @NotBlank Long categoryId, @NotBlank String image) {
}