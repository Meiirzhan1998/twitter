package com.meiirzhan.twitter.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class UserDto {
    private Long id;

    private String firstName;

    private  String middleName;

    private  String lastName;

    private String phone;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private  String password;

}


