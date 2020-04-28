package com.home.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.home.spring.model.Users;

@Repository
public class UserRepositoryDaoImpl implements UserRepository {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	

	@Transactional(rollbackFor = { Exception.class })
	public Users findByUsername(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		String query = "from Users emp  where Users.Username = :name";
		Users user = (Users) session.createQuery(query);
			
		return user;
	}

	
	
}
