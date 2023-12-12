package com.techMall.api.services.product;

import com.techMall.api.models.entities.ProductEntity;
import com.techMall.api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IndexProductService {

    @Autowired
    private ProductRepository repository;

    public List<ProductEntity> index(){
        List<ProductEntity> products = repository.findAll();
        return products;
    }
}