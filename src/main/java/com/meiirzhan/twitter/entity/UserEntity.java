package com.meiirzhan.twitter.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.List;
import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity(name = "twitter_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String secondName;

    private String lastName;

    private String login;

    private String password;

    @OneToMany
    private List<BlogEntity> blogEntities;
}


