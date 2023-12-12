package com.techMall.api.controller.product;

import com.techMall.api.models.dto.ProductDTO;
import com.techMall.api.models.entities.ProductEntity;
import com.techMall.api.services.product.UpdateProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/update")
public class UpdateProductController {

    @Autowired
    private UpdateProductService service;

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ProductEntity> update(@RequestBody ProductDTO data, @PathVariable Long id){
        ProductEntity product = service.update(data, id);
        return ResponseEntity.ok().body(product);
    }
}