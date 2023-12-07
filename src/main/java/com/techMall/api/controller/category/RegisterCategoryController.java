package com.techMall.api.controller.category;

import com.techMall.api.models.dto.CategoryDTO;
import com.techMall.api.models.entities.CategoryEntity;
import com.techMall.api.services.category.RegisterCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/register")
public class RegisterCategoryController {

    @Autowired
    private RegisterCategoryService service;

    @PostMapping(value = "/category")
    public ResponseEntity<CategoryEntity> register(@RequestBody CategoryDTO data){
        CategoryEntity category = service.register(data);
        URI uri = ServletUriComponentsBuilder.fromUriString("http://localhost:8080/api/v1/category").path("{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}