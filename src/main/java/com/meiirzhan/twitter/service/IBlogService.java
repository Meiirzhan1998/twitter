package com.meiirzhan.twitter.service;

import com.meiirzhan.twitter.dto.BlogDto;

public interface IBlogService {
    BlogDto add( BlogDto blogDto);
    java.util.List<BlogDto> getAllByUserId(long id);
    java.util.List<BlogDto> findByFilter(String filter);
}
