package com.techMall.api.services.customer;

import com.techMall.api.models.entities.CustomerEntity;
import com.techMall.api.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexCustomersService {

    @Autowired
    private CustomerRepository repository;

    public List<CustomerEntity> index(){
        List<CustomerEntity> customers = repository.findAll();
        return customers;
    }
}