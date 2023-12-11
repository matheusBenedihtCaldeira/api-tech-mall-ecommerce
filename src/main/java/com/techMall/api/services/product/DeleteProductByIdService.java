package com.techMall.api.services.product;

import com.techMall.api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductByIdService {

    @Autowired
    private ProductRepository repository;

    public void delete(Long id){
        repository.deleteById(id);
    }
}