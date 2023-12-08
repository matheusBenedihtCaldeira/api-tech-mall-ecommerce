package com.techMall.api.services.category;

import com.techMall.api.models.dto.CategoryDTO;
import com.techMall.api.models.entities.CategoryEntity;
import com.techMall.api.repositories.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCategoryService {

    @Autowired
    private CategoryRepository repository;

    public CategoryEntity update(CategoryDTO data, Long id){
        CategoryEntity category = new CategoryEntity();
        CategoryEntity categoryFromDb = repository.findById(id).get();
        BeanUtils.copyProperties(data, category);
        category.setId(id);
        BeanUtils.copyProperties(category, categoryFromDb);
        return repository.save(category);
    }
}