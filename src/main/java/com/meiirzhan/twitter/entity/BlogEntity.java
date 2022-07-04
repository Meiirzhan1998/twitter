package com.meiirzhan.twitter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity(name = "blog")
public class BlogEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String title;

    private String description;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}
