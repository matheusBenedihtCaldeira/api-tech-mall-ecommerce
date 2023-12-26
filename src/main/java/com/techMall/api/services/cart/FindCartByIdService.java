package com.techMall.api.services.cart;

import com.techMall.api.models.entities.CartEntity;
import com.techMall.api.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindCartByIdService {

    @Autowired
    private CartRepository repository;

    public CartEntity findCartById(Long id){
        CartEntity cart = repository.findById(id).get();
        return cart;
    }
}