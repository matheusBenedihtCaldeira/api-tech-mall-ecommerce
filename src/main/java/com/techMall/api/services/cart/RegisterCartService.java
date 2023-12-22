package com.techMall.api.services.cart;

import com.techMall.api.models.entities.CartEntity;
import com.techMall.api.models.entities.CustomerEntity;
import com.techMall.api.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCartService {

    @Autowired
    private CartRepository repository;

    public CartEntity register(CartEntity cart){
        return repository.save(cart);
    }
}