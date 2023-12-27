package com.techMall.api.services.cart;

import com.techMall.api.models.entities.CartEntity;
import com.techMall.api.models.entities.CustomerEntity;
import com.techMall.api.repositories.CartRepository;
import com.techMall.api.repositories.CustomerRepository;
import com.techMall.api.services.customer.FindCustomerByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindCartByIdService {

    @Autowired
    private FindCustomerByIdService findCustomerByIdService;

    public CartEntity findCartById(Long id){
        CustomerEntity customer = findCustomerByIdService.findCustomerById(id);
        CartEntity cart = customer.getCart();
        return cart;
    }
}