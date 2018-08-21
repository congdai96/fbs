package com.atom.fbs.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import com.atom.fbs.dao.UserDAO;
import com.atom.fbs.dto.User;

@Repository("userDAO")
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return (Session) sessionFactory.getCurrentSession();
	}

	@Override
	public User addUser(User user) {
		return (User) getSession().save(user);
	}
}
