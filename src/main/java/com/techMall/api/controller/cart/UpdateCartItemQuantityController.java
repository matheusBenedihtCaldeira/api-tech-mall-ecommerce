package com.techMall.api.controller.cart;

import com.techMall.api.models.requests.UpdateCartItemQuantityRequest;
import com.techMall.api.services.cart.UpdateCartItemQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/cart")
public class UpdateCartItemQuantityController {

    @Autowired
    private UpdateCartItemQuantityService service;

    @PutMapping(value = "/update/cartItem")
    public ResponseEntity<Void> updateCartItemQuantity(@RequestBody UpdateCartItemQuantityRequest data){
        service.updateCartItemQuantity(data);
        return ResponseEntity.noContent().build();
    }
}
