package com.techMall.api.services.user;

import com.techMall.api.models.dto.AddressDTO;
import com.techMall.api.models.dto.UserDTO;
import com.techMall.api.models.entities.AddressEntity;
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
        UserEntity user = convertUserDTO(data);
        AddressEntity address = convertAddressDTO(data.address());
        user.setAddress(address);
        return repository.save(user);
    }

    private UserEntity convertUserDTO(UserDTO data){
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(data, user);
        return user;
    }

    private AddressEntity convertAddressDTO(AddressDTO data){
        AddressEntity address = new AddressEntity();
        BeanUtils.copyProperties(data, address);
        return address;
    }
}