package com.meiirzhan.twitter.service.impl;

import com.meiirzhan.twitter.entity.UserEntity;
import com.meiirzhan.twitter.dto.UserDto;
import com.meiirzhan.twitter.repositories.UserRepository;
import com.meiirzhan.twitter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public java.util.List<UserDto> getAll() {
        java.util.List<UserEntity> userEntityList = userRepo.findAll();
        java.util.List<UserDto> userDtoList = new ArrayList<>();
        for (UserEntity userEntity : userEntityList) {
            userDtoList.add(mapToEntity(userEntity));
        }
        return userDtoList;
    }

    public UserDto mapToEntity(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setMiddleName(userEntity.getSecondName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setPhone(userEntity.getLogin());
        return userDto;
    }


    public boolean addUser(UserDto userDto) {
        UserEntity userEntityFromDb = userRepo.findByLogin(userDto.getPhone());
        if (userEntityFromDb != null) {
            return false;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setSecondName(userDto.getMiddleName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setLogin(userDto.getPhone());
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepo.save(userEntity);
        return true;
    }
}