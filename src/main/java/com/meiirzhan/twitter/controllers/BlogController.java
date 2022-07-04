package com.meiirzhan.twitter.controllers;

import com.meiirzhan.twitter.dto.BlogDto;
import com.meiirzhan.twitter.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @PostMapping("/add")
    public BlogDto add(@RequestBody BlogDto blogDto) throws Exception {
        return iBlogService.add(blogDto);
    }

    @GetMapping("getAllByUserId/{id}")
    public List getAllByUserId(@PathVariable long id) {
        return iBlogService.getAllByUserId(id);
    }

    @GetMapping("/findByFilter/{filter}")
    public List<BlogDto> findByFilter(@PathVariable String filter) {
        return iBlogService.findByFilter(filter);
    }
}
