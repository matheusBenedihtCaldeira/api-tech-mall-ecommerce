package com.techMall.api.controller.category;

import com.techMall.api.models.dto.CategoryDTO;
import com.techMall.api.models.entities.CategoryEntity;
import com.techMall.api.services.category.UpdateCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/update")
public class UpdateCategoryController {

    @Autowired
    private UpdateCategoryService service;

    @PutMapping(value = "/category/{id}")
    public ResponseEntity<CategoryEntity> update(@RequestBody CategoryDTO data, @PathVariable Long id){
        CategoryEntity category = service.update(data, id);
        return ResponseEntity.ok().body(category);
    }
}
