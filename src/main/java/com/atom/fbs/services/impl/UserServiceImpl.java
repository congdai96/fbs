package com.atom.fbs.services.impl;

import org.apache.log4j.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atom.fbs.dao.UserDAO;
import com.atom.fbs.dto.User;
import com.atom.fbs.services.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAO userDAO;

	@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email = :email";
		try {
		return userDAO.getByEmail(email);
		}
		catch(Exception e) {
			throw e;
		}
							
	}
	
	@Override
	public User get(int id) {
		try {			
			return userDAO.get(id);	
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public boolean add(User user) {
		try {			
			userDAO.add(user);
			return true;
		}
		catch(Exception e) {
			throw e;
		}
	}
}
