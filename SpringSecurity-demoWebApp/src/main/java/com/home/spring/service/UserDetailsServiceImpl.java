package com.home.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.home.spring.model.Users;


@Service("customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {


	
	@Autowired
	UserService repo;
	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Users us = repo.findByUserName(userName);
		if (us != null ) {
			System.out.println("UserDetailsService: " + us.toString());
			return new  org.springframework.security.core.userdetails.User(us.getUserName(), us.getPass(), getAuthorities(us));
		}
		throw new UsernameNotFoundException("Username not found");
	}
	
	private List<GrantedAuthority> getAuthorities (Users us) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + us.getType()));
		return authorities;
	}

}
