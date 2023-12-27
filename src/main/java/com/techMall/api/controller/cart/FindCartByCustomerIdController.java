package com.techMall.api.controller.cart;

import com.techMall.api.models.entities.CartEntity;
import com.techMall.api.services.cart.FindCartByIdService;
import com.techMall.api.services.cartItems.FindCartItemByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/cart")
public class FindCartByCustomerIdController {

    @Autowired
    private FindCartByIdService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CartEntity> findCartById(@PathVariable Long id){
        CartEntity cart = service.findCartById(id);
        return ResponseEntity.ok().body(cart);
    }
}
