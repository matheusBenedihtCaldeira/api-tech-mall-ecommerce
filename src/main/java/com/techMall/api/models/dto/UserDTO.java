package com.techMall.api.models.dto;

import com.techMall.api.models.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(Long id, @NotBlank String firstName, @NotBlank String lastName, @NotBlank @Email String email, @NotBlank String cellPhone, @NotBlank String password, @NotBlank Role role) {
}