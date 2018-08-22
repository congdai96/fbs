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
	public User createUser(User user) {
		logger.info("User Service - start create method");
		try {
			return userDAO.addUser(user);
		} catch (Exception e) {
			logger.error("create User:", e);
			throw e;
		}
	}
}
