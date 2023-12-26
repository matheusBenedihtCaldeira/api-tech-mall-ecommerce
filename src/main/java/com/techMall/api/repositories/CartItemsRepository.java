package com.techMall.api.repositories;

import com.techMall.api.models.entities.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsRepository extends JpaRepository<CartItemEntity, Long> {
}