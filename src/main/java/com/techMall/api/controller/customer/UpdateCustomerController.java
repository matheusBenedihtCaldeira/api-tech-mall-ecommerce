package com.techMall.api.controller.customer;

import com.techMall.api.models.dto.CustomerDTO;
import com.techMall.api.models.entities.CustomerEntity;
import com.techMall.api.services.customer.UpdateCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/update")
public class UpdateCustomerController {

    @Autowired
    private UpdateCustomerService service;

    @PutMapping(value = "/customer/{id}")
    public ResponseEntity<CustomerEntity> update(@RequestBody CustomerDTO data, @PathVariable Long id){
        CustomerEntity customer = service.update(data, id);
        return ResponseEntity.ok().body(customer);
    }
}
