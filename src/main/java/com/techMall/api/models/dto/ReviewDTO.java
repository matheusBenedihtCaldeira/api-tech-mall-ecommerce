package com.techMall.api.models.dto;

import jakarta.validation.constraints.NotBlank;

public record ReviewDTO(Long id, @NotBlank String review, @NotBlank Integer note, Long customerId, Long productId) {
}