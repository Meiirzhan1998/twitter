package com.meiirzhan.twitter.controllers;

import com.meiirzhan.twitter.dto.UserDto;
import com.meiirzhan.twitter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    @GetMapping("/getAll")
    public java.util.List<UserDto> getAll(){
        return iUserService.getAll();
    }
}
