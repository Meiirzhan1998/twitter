package com.meiirzhan.twitter.controllers;

import com.meiirzhan.twitter.dto.UserDto;
import com.meiirzhan.twitter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegistrationController {

    @Autowired
    IUserService iUserService;

    @PostMapping("/registration")
    public String addUser(@RequestBody UserDto userDto) {
        iUserService.addUser(userDto);
        return "Success";
    }
}
