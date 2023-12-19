package com.techMall.api.controller.user;

import com.techMall.api.models.dto.UserDTO;
import com.techMall.api.models.entities.UserEntity;
import com.techMall.api.services.user.UpdateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/update/")
public class UpdateUserController {

    @Autowired
    private UpdateUserService service;

    @PutMapping(value = "/user/{id}")
    public ResponseEntity<UserEntity> update(@RequestBody UserDTO data, @PathVariable Long id){
        UserEntity user = service.update(data, id);
        return ResponseEntity.ok().body(user);
    }
}