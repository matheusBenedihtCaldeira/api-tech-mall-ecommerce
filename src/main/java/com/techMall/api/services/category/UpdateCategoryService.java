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

    @Autowired
    private FindCategoryByIdService findCategoryByIdService;

    public CategoryEntity update(CategoryDTO data, Long id){
        CategoryEntity category = convertDTO(data);
        CategoryEntity dataFromDb = findCategoryByIdService.findById(id);
        updateData(category, dataFromDb);
        return repository.save(dataFromDb);
    }

    private void updateData(CategoryEntity dataToUpdate, CategoryEntity dataFromDB){
        dataToUpdate.setId(dataFromDB.getId());
        BeanUtils.copyProperties(dataToUpdate, dataFromDB);
    }

    private CategoryEntity convertDTO(CategoryDTO data){
        CategoryEntity category = new CategoryEntity();
        BeanUtils.copyProperties(data, category);
        return category;
    }
}