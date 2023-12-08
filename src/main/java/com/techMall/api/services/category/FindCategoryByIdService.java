package com.techMall.api.services.category;

import com.techMall.api.models.entities.CategoryEntity;
import com.techMall.api.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindCategoryByIdService {

    @Autowired
    private CategoryRepository repository;

    public CategoryEntity findById(Long id){
        return repository.findById(id).get();
    }
}