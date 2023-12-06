package com.techMall.api.controller.customer;

import com.techMall.api.models.dto.CustomerDTO;
import com.techMall.api.models.entities.CustomerEntity;
import com.techMall.api.services.customer.RegisterCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/register")
public class RegisterCustomerController {

    @Autowired
    private RegisterCustomerService service;

    @PostMapping(value = "/customer")
    ResponseEntity<CustomerEntity> register(@RequestBody CustomerDTO data){
        CustomerEntity customer = service.register(data);
        return ResponseEntity.ok().body(customer);
    }
}