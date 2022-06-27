package com.meiirzhan.twitter.service;

import com.meiirzhan.twitter.dto.UserDto;

public interface IUserService {
    java.util.List<UserDto> getAll();

    boolean addUser(UserDto userDto);
}
