package com.meiirzhan.twitter.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class BlogDto {

    private long id;

    private String title;

    private String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long userId;

    private UserDto userDto;
}
