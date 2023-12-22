package com.techMall.api.services.customer;

import com.techMall.api.models.dto.AddressDTO;
import com.techMall.api.models.dto.CustomerDTO;
import com.techMall.api.models.entities.AddressEntity;
import com.techMall.api.models.entities.CartEntity;
import com.techMall.api.models.entities.CustomerEntity;
import com.techMall.api.repositories.CustomerRepository;
import com.techMall.api.services.cart.RegisterCartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RegisterCartService registerCartService;

    public CustomerEntity register(CustomerDTO data){
        //Cria a entidade de customer
        CustomerEntity customer = convertDTO(data);
        AddressEntity address = convertDTO(data.address());
        customer.setAddress(address);
        //Registra o cliente para gerar o ID
        customerRepository.save(customer);

        // Cria o carrinho para associar ao cliente
        CartEntity cart = new CartEntity();
        cart.setCustomer(customer);
        registerCartService.register(cart);
        // Associa o carrinho ao cliente e atualiza no banco de dados
        customer.setCart(cart);
        customerRepository.save(customer);
        return customer;
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