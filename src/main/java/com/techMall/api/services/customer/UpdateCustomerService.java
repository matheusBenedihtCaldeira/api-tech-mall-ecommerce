package com.techMall.api.services.customer;

import com.techMall.api.models.dto.CustomerDTO;
import com.techMall.api.models.entities.AddressEntity;
import com.techMall.api.models.entities.CustomerEntity;
import com.techMall.api.repositories.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.beans.Beans;

@Service
public class UpdateCustomerService {

    @Autowired
    private CustomerRepository repository;

    public CustomerEntity update(CustomerDTO data, Long id){
        CustomerEntity customerWithDataToUpdate = new CustomerEntity();
        CustomerEntity customerFromDB = repository.findById(id).get();
        BeanUtils.copyProperties(data, customerWithDataToUpdate);
        customerWithDataToUpdate.setId(id);
        customerWithDataToUpdate.setAddress(customerFromDB.getAddress());
        BeanUtils.copyProperties(customerWithDataToUpdate, customerFromDB);
        return repository.save(customerFromDB);
    }
}