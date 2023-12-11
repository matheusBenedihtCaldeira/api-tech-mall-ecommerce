package com.techMall.api.controller.product;

import com.techMall.api.models.dto.ProductViewResponse;
import com.techMall.api.models.entities.ProductEntity;
import com.techMall.api.services.product.IndexProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products")
public class IndexProductController {

    @Autowired
    private IndexProductService service;

    @GetMapping
    public ResponseEntity<List<ProductViewResponse>> index(){
        List<ProductViewResponse> products = service.index();
        return ResponseEntity.ok().body(products);
    }
}