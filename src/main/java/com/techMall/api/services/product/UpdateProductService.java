package com.techMall.api.services.product;

import com.techMall.api.models.dto.ProductDTO;
import com.techMall.api.models.entities.CategoryEntity;
import com.techMall.api.models.entities.ProductEntity;
import com.techMall.api.repositories.ProductRepository;
import com.techMall.api.services.category.FindCategoryByIdService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private FindCategoryByIdService findCategoryByIdService;

    @Autowired
    private FindProductByIdService findProductByIdService;

    public ProductEntity update(ProductDTO data, Long id){
        ProductEntity dataToUpdate = convertDTO(data);
        ProductEntity dataFromDB = repository.findById(id).get();
        addCategory(dataToUpdate, data.categoryId());
        updateDate(dataToUpdate, dataFromDB);
        return repository.save(dataFromDB);
    }

    private void updateDate(ProductEntity dataToUpdate, ProductEntity dataFromDB){
        dataToUpdate.setId(dataFromDB.getId());
        dataToUpdate.setCreatedAt(dataFromDB.getCreatedAt());
        BeanUtils.copyProperties(dataToUpdate, dataFromDB);
    }

    public void addCategory(ProductEntity dataToUpdate, Long id){
        CategoryEntity category = findCategoryByIdService.findById(id);
        dataToUpdate.setCategory(category);
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