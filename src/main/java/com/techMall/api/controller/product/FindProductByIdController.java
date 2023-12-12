package com.techMall.api.controller.product;

import com.techMall.api.models.entities.ProductEntity;
import com.techMall.api.services.product.FindProductByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/product/")
public class FindProductByIdController {

    @Autowired
    private FindProductByIdService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductEntity> findProductById(@PathVariable Long id){
        ProductEntity product = service.findProductById(id);
        return ResponseEntity.ok().body(product);
    }
}