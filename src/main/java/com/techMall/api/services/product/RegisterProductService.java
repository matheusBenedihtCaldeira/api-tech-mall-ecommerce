package com.techMall.api.services.product;

import com.techMall.api.models.dto.ProductDTO;
import com.techMall.api.models.entities.CategoryEntity;
import com.techMall.api.models.entities.ProductEntity;
import com.techMall.api.repositories.CategoryRepository;
import com.techMall.api.repositories.ProductRepository;
import com.techMall.api.services.category.FindCategoryByIdService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private FindCategoryByIdService findCategoryByIdService;

    public ProductEntity register(ProductDTO data){
        ProductEntity product = convertDTO(data);
        CategoryEntity category = findCategoryByIdService.findById(data.categoryId());
        product.setCategory(category);
        return productRepository.save(product);
    }

    private ProductEntity convertDTO(ProductDTO data){
        ProductEntity product = new ProductEntity();
        product.setName(data.name());
        product.setDescription(data.description());
        product.setStockQuantity(data.stockQuantity());
        product.setPrice(data.price());
        product.setImage(data.image());
        return product;
    }
}