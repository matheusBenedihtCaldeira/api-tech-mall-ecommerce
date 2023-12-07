package com.techMall.api.services.category;

import com.techMall.api.models.dto.CategoryDTO;
import com.techMall.api.models.entities.CategoryEntity;
import com.techMall.api.repositories.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCategoryService {

    @Autowired
    private CategoryRepository repository;

    public CategoryEntity register(CategoryDTO data){
        CategoryEntity category = convertDTO(data);
        return repository.save(category);
    }

    private CategoryEntity convertDTO(CategoryDTO data){
        CategoryEntity category = new CategoryEntity();
        BeanUtils.copyProperties(data, category);
        return category;
    }
}