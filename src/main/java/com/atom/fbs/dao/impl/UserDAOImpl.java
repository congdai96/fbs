package com.atom.fbs.dao.impl;

import org.hibernate.Session;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atom.fbs.dao.UserDAO;
import com.atom.fbs.dto.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return (Session) sessionFactory.getCurrentSession();
	}


	@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email = :email";
		return 
				(User)	getSession().createQuery(selectQuery,User.class)
						.setParameter("email",email)
							.getSingleResult();							
	}
	
	@Override
	public User get(int id) {		
			return (User) getSession().get(User.class, id);			
	}
	
	@Override
	public void add(User user) {			
		getSession().persist(user);			
		}

	
}
