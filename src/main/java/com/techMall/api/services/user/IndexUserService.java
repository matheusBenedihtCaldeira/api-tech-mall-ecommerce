package com.techMall.api.services.user;

import com.techMall.api.models.entities.UserEntity;
import com.techMall.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexUserService {

    @Autowired
    private UserRepository repository;

    public List<UserEntity> index(){
        List<UserEntity> users = repository.findAll();
        return users;
    }
}