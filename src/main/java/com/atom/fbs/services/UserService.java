package com.atom.fbs.services;

import com.atom.fbs.dto.User;

public interface UserService {
	User getByEmail(String email) throws Exception;
	User get(int id) throws Exception;
	
	boolean add(User user);
}
