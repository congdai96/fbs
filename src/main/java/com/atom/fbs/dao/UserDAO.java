package com.atom.fbs.dao;

import com.atom.fbs.dto.User;

public interface UserDAO {

	User getByEmail(String email);
	User get(int id);
	
	void add(User user);

}
