package com.techMall.api.services.product;

import com.techMall.api.models.dto.ProductViewResponse;
import com.techMall.api.models.entities.ProductEntity;
import com.techMall.api.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindProductByIdService {

    @Autowired
    private ProductRepository repository;

    public ProductViewResponse findProductById(Long id){
        ProductEntity product = repository.findById(id).get();
        return convertDTO(product);
    }

    public ProductViewResponse convertDTO(ProductEntity product){
        return new ProductViewResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getStockQuantity(),
                product.getPrice(),
                product.getCategory().getCategoryName()
        );
    }
}