package com.techMall.api.services.category;

import com.techMall.api.models.entities.CategoryEntity;
import com.techMall.api.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexCategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<CategoryEntity> index(){
        List<CategoryEntity> categories = repository.findAll();
        return categories;
    }
}