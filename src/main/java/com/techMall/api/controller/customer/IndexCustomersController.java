package com.techMall.api.controller.customer;

import com.techMall.api.models.entities.CustomerEntity;
import com.techMall.api.services.customer.IndexCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/customers")
public class IndexCustomersController {

    @Autowired
    private IndexCustomersService service;

    @GetMapping
    ResponseEntity<List<CustomerEntity>> index(){
        List<CustomerEntity> customers = service.index();
        return ResponseEntity.ok().body(customers);
    }
}