package com.meiirzhan.twitter.service.impl;

import com.meiirzhan.twitter.entity.UserEntity;
import com.meiirzhan.twitter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByLogin(login);
		if (userEntity != null) {
			return new org.springframework.security.core.userdetails.User(userEntity.getLogin(), userEntity.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + login);
		}
	}
}