package com.techMall.api.services.cartItems;

import com.techMall.api.models.entities.CartItemEntity;
import com.techMall.api.repositories.CartItemsRepository;
import com.techMall.api.services.cart.RegisterCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindCartItemByIdService {

    @Autowired
    private CartItemsRepository repository;

    public CartItemEntity findCartItemById(Long id){
        return repository.findById(id).get();
    }
}