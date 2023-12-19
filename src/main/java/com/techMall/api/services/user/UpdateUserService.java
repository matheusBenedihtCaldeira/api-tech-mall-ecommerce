package com.techMall.api.services.user;

import com.techMall.api.models.dto.UserDTO;
import com.techMall.api.models.entities.UserEntity;
import com.techMall.api.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity update(UserDTO data, Long id){
        UserEntity dataFromDb = userRepository.findById(id).get();
        UserEntity dataToUpdate = convertDTO(data);
        updateData(dataToUpdate, dataFromDb);
        return userRepository.save(dataFromDb);
    }

    private void updateData(UserEntity dataToUpdate, UserEntity dataFromDB){
        dataToUpdate.setId(dataFromDB.getId());
        dataToUpdate.setAddress(dataFromDB.getAddress());
        BeanUtils.copyProperties(dataToUpdate, dataFromDB);
    }

    private UserEntity convertDTO(UserDTO data){
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(data, user);
        return user;
    }
}