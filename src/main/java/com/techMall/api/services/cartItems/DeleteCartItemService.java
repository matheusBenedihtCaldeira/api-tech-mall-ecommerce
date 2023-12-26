package com.techMall.api.services.cartItems;

import com.techMall.api.repositories.CartItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCartItemService {

    @Autowired
    private CartItemsRepository repository;

    public void delete(Long id){
        repository.deleteById(id);
    }
}