package com.techMall.api.services.category;

import com.techMall.api.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCategoryService {

    @Autowired
    private CategoryRepository repository;

    public void delete(Long id){
        repository.deleteById(id);
    }
}