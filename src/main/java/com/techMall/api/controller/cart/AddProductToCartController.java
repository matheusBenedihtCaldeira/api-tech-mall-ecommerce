package com.techMall.api.controller.cart;

import com.techMall.api.models.entities.CartEntity;
import com.techMall.api.models.requests.AddProductToCartRequest;
import com.techMall.api.services.cart.AddProductToCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/addProduct")
public class AddProductToCartController {

    @Autowired
    private AddProductToCartService service;

    @PostMapping(value = "/{id}")
    public ResponseEntity<CartEntity> addProductToCard(@PathVariable Long id, @RequestBody AddProductToCartRequest data){
        CartEntity cart = service.addProductToCart(id, data);
        return ResponseEntity.ok().body(cart);
    }
}
