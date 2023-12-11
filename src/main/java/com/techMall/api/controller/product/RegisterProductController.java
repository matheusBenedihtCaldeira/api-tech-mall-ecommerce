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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/register")
public class RegisterProductController {

    @Autowired
    private RegisterProductService service;

    @PostMapping(value = "/product")
    public ResponseEntity<ProductEntity> register(@RequestBody ProductDTO data){
        ProductEntity product = service.register(data);
        URI uri = ServletUriComponentsBuilder.fromUriString("http://localhost:8080/api/v1/product/").path("{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
