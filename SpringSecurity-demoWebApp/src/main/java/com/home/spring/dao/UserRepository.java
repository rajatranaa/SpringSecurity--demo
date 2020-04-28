package com.home.spring.dao;

import com.home.spring.model.Users;


public interface UserRepository {

	Users findByUsername(String name);
	
	
}
