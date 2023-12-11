package com.techMall.api.models.dto;

public record ProductViewResponse(Long id, String name, String description, Integer Quantity, Double price, String categoryName) {
}