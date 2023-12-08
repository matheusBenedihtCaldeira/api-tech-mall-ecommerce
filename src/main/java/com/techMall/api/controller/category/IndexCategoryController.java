package com.techMall.api.controller.category;

import com.techMall.api.models.entities.CategoryEntity;
import com.techMall.api.services.category.IndexCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/categories")
public class IndexCategoryController {

    @Autowired
    private IndexCategoryService service;

    @GetMapping
    public ResponseEntity index(){
        List<CategoryEntity> categories = service.index();
        return ResponseEntity.ok().body(categories);
    }
}