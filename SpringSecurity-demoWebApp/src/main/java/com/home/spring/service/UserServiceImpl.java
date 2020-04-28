package com.home.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.spring.dao.UserRepository;
import com.home.spring.model.Users;

@Service("UserService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repo;
	

	@Override
	public Users findByUserName(String name) {
		return repo.findByUsername(name);
	}

		
	
}
