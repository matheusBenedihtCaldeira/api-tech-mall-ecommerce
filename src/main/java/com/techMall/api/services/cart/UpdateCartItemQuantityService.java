package com.techMall.api.services.cart;

import com.techMall.api.models.entities.CartEntity;
import com.techMall.api.models.entities.CartItemEntity;
import com.techMall.api.models.requests.UpdateCartItemQuantityRequest;
import com.techMall.api.repositories.CartItemsRepository;
import com.techMall.api.services.cartItems.FindCartItemByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCartItemQuantityService {

    @Autowired
    private CartItemsRepository repository;

    @Autowired
    private FindCartItemByIdService findCartItemByIdService;

    @Autowired
    private FindCartByIdService findCartByIdService;

    public void updateCartItemQuantity(UpdateCartItemQuantityRequest data){
        CartItemEntity cartItemEntity = findCartItemByIdService.findCartItemById(data.cartItemId());
        cartItemEntity.setQuantity(data.quantity());
        repository.save(cartItemEntity);
    }
}