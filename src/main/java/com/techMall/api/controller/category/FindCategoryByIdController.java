package com.techMall.api.controller.category;

import com.techMall.api.models.entities.CategoryEntity;
import com.techMall.api.services.category.FindCategoryByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/category")
public class FindCategoryByIdController {

    @Autowired
    private FindCategoryByIdService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryEntity> findCategoryById(@PathVariable Long id){
        CategoryEntity category = service.findById(id);
        return ResponseEntity.ok().body(category);
    }
}