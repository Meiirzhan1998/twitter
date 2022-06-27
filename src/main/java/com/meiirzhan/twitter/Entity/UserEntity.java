package com.meiirzhan.twitter.Entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity(name = "users")
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
    private java.util.List<BlogEntity> blogEntities;
}


