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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/register")
public class RegisterCustomerController {

    @Autowired
    private RegisterCustomerService service;

    @PostMapping(value = "/customer")
    ResponseEntity<CustomerEntity> register(@RequestBody CustomerDTO data){
        CustomerEntity customer = service.register(data);
        URI uri = ServletUriComponentsBuilder.fromUriString("http://localhost:8080/api/v1/customer/").path("{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}