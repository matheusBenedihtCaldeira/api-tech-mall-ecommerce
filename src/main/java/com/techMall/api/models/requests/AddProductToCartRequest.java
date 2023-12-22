package com.techMall.api.models.requests;

public record AddProductToCartRequest(Long productId, Integer quantity) {
}
