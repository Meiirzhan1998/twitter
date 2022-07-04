package com.meiirzhan.twitter.service.impl;

import com.meiirzhan.twitter.entity.BlogEntity;
import com.meiirzhan.twitter.entity.UserEntity;
import com.meiirzhan.twitter.dto.BlogDto;
import com.meiirzhan.twitter.dto.UserDto;
import com.meiirzhan.twitter.repositories.BlogRepo;
import com.meiirzhan.twitter.repositories.UserRepository;
import com.meiirzhan.twitter.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    protected BlogRepo blogRepo;

    @Autowired
    protected UserRepository userRepo;


    public BlogDto add(BlogDto blogDto) {
        Optional<UserEntity> optionalUser = userRepo.findById(blogDto.getUserId());
        if (!optionalUser.isPresent()) {
            try {
                throw new Exception("FUCK YOU");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setTitle(blogDto.getTitle());
        blogEntity.setDescription(blogDto.getDescription());
        blogEntity.setUserEntity(optionalUser.get());

        blogEntity = blogRepo.save(blogEntity);

        return toDto(blogEntity);
    }

    public BlogDto toDto(BlogEntity blogEntity) {
        BlogDto dto = new BlogDto();
        if (blogEntity != null) {
            dto.setId(blogEntity.getId());
            dto.setTitle(blogEntity.getTitle());
            dto.setDescription(blogEntity.getDescription());
        }
        UserEntity userEntity = blogEntity.getUserEntity();
        if (userEntity != null) {
            UserDto userDto = new UserDto();
            userDto.setLastName(userEntity.getLastName());
            userDto.setMiddleName(userEntity.getSecondName());
            userDto.setFirstName(userEntity.getFirstName());
            userDto.setId(userEntity.getId());
            userDto.setPhone(userEntity.getLogin());
            dto.setUserDto(userDto);
        }
        return dto;
    }

    public java.util.List<BlogDto> getAllByUserId(long id) {
        java.util.List<BlogEntity> blogEntityList = blogRepo.findAllByUserEntityId(id);
        java.util.List<BlogDto> blogDtoList = new ArrayList<>();
        for (BlogEntity blogEntity : blogEntityList) {
            blogDtoList.add(toDto(blogEntity));
        }
        return blogDtoList;
    }


    public java.util.List<BlogDto> findByFilter(String filter) {
        java.util.List<BlogEntity> blogEntityList = blogRepo.findByFilter(filter);
        java.util.List<BlogDto> blogDtoList = new ArrayList<>();
        for (BlogEntity blogEntity : blogEntityList) {
            blogDtoList.add(toDto(blogEntity));
        }
        return blogDtoList;
    }
}
