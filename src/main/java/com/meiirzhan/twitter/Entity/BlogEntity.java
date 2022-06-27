package com.meiirzhan.twitter.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity(name = "blogs")
public class BlogEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String title;

    private String description;

    @ManyToOne
    @JsonIgnore
    private UserEntity userEntity;
}
