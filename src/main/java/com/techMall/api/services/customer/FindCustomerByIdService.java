package com.techMall.api.services.customer;

import com.techMall.api.models.entities.CustomerEntity;
import com.techMall.api.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindCustomerByIdService {

    @Autowired
    private CustomerRepository repository;

    public CustomerEntity findCustomerById(Long id){
        CustomerEntity customer = repository.findById(id).get();
        return customer;
    }
}