package com.techMall.api.services.customer;

import com.techMall.api.models.dto.AddressDTO;
import com.techMall.api.models.dto.CustomerDTO;
import com.techMall.api.models.entities.AddressEntity;
import com.techMall.api.models.entities.CustomerEntity;
import com.techMall.api.repositories.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCustomerService {

    @Autowired
    private CustomerRepository repository;

    public CustomerEntity register(CustomerDTO data){
        CustomerEntity customer = convertDTO(data);
        AddressEntity address = convertDTO(data.address());
        customer.setAddress(address);
        return repository.save(customer);
    }

    private CustomerEntity convertDTO(CustomerDTO data){
        CustomerEntity customer = new CustomerEntity();
        BeanUtils.copyProperties(data, customer);
        return customer;
    }

    private AddressEntity convertDTO(AddressDTO data){
        AddressEntity address = new AddressEntity();
        BeanUtils.copyProperties(data, address);
        return address;
    }
}