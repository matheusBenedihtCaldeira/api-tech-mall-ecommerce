package com.techMall.api.services.user;

import com.techMall.api.models.entities.UserEntity;
import com.techMall.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindUserByIdService {

    @Autowired
    private UserRepository repository;

    public UserEntity findUserById(Long id){
        return repository.findById(id).get();
    }
}