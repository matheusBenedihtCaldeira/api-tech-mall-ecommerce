package com.techMall.api.controller.product;

import com.techMall.api.models.dto.ProductDTO;
import com.techMall.api.models.entities.ProductEntity;
import com.techMall.api.services.product.RegisterProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/register")
public class RegisterProductController {

    @Autowired
    private RegisterProductService service;

    @PostMapping(value = "/product")
    public ResponseEntity<ProductEntity> register(@RequestBody ProductDTO data){
        ProductEntity product = service.register(data);
        return ResponseEntity.ok().body(product);
    }
}
