package com.techMall.api.models.requests;

public record UpdateCartItemQuantityRequest(Long cartItemId, Integer quantity) {
}