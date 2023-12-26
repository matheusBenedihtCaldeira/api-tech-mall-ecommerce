package com.techMall.api.controller.cart;

import com.techMall.api.models.entities.CartEntity;
import com.techMall.api.models.requests.RemoveProductFromCartRequest;
import com.techMall.api.services.cart.RemoveProductFromCartService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/cart")
public class RemoveProductFromCartController {

    @Autowired
    private RemoveProductFromCartService service;

    @DeleteMapping(value = "/remove/product/{id}")
    public ResponseEntity<Void> removeProductFromCart(@PathVariable Long id, @RequestBody RemoveProductFromCartRequest data){
        service.removeProductFromCart(id, data);
        return ResponseEntity.noContent().build();
    }
}