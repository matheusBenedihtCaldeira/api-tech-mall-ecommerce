package com.techMall.api.models.dto;

import jakarta.validation.constraints.NotBlank;

public record AddressDTO(Long id, @NotBlank String streetAddress, @NotBlank String neighborhood, @NotBlank String complement, @NotBlank String city, @NotBlank String uf, @NotBlank String cep, @NotBlank Integer number) {
}