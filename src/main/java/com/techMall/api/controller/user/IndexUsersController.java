package com.techMall.api.controller.user;

import com.techMall.api.models.entities.UserEntity;
import com.techMall.api.services.user.IndexUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class IndexUsersController {

    @Autowired
    private IndexUserService service;

    @GetMapping
    public ResponseEntity<List<UserEntity>> index(){
        List<UserEntity> users = service.index();
        return ResponseEntity.ok().body(users);
    }
}