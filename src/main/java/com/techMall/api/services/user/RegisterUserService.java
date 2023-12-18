package com.techMall.api.services.user;

import com.techMall.api.models.dto.UserDTO;
import com.techMall.api.models.entities.UserEntity;
import com.techMall.api.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    @Autowired
    private UserRepository repository;

    public UserEntity register(UserDTO data){
        UserEntity user = convertDTO(data);
        return repository.save(user);
    }

    private UserEntity convertDTO(UserDTO data){
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(data, user);
        return user;
    }
}