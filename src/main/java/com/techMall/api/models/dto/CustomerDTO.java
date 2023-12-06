package com.techMall.api.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerDTO(Long id, @NotBlank String firstName, @NotBlank String lastName, @NotBlank @Email String email, @NotBlank AddressDTO address, @NotBlank String cellPhone, @NotBlank String password) {
}