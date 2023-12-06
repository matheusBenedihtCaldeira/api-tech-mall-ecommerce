package com.techMall.api.controller.customer;

import com.techMall.api.models.entities.CustomerEntity;
import com.techMall.api.services.customer.FindCustomerByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/customer")
public class FindCustomerByIdController {

    @Autowired
    private FindCustomerByIdService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerEntity> findCustomerByID(@PathVariable Long id){
        CustomerEntity customer = service.findCustomerById(id);
        return ResponseEntity.ok().body(customer);
    }
}