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

    @Autowired
    private FindCustomerByIdService findCustomerByIdService;
    public CustomerEntity update(CustomerDTO data, Long id){
        CustomerEntity dataToUpdate = convertDTO(data);
        CustomerEntity dataFromDB = findCustomerByIdService.findCustomerById(id);
        updateData(dataToUpdate, dataFromDB);
        return repository.save(dataFromDB);
    }

    private void updateData(CustomerEntity dataToUpdate, CustomerEntity dataFromDB){
        dataToUpdate.setId(dataFromDB.getId());
        dataToUpdate.setAddress(dataFromDB.getAddress());
        BeanUtils.copyProperties(dataToUpdate, dataFromDB);
    }

    private CustomerEntity convertDTO(CustomerDTO customerDTO){
        CustomerEntity customer = new CustomerEntity();
        BeanUtils.copyProperties(customerDTO, customer);
        return customer;
    }
}