package com.techMall.api.controller.user;

import com.techMall.api.models.entities.UserEntity;
import com.techMall.api.services.user.FindUserByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/user/")
public class FindUserByIdController {

    @Autowired
    private FindUserByIdService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserEntity> findUserById(@PathVariable Long id){
        UserEntity user = service.findUserById(id);
        return ResponseEntity.ok().body(user);
    }
}