package com.atom.fbs.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.atom.fbs.dao.CartDAO;
import com.atom.fbs.dto.Cart;

@Repository("cartDAO")
public class CartDAOImpl extends HibernateDaoSupport implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return (Session) sessionFactory.getCurrentSession();
	}

	@Override
	public Cart addCart(Cart cart) {
		return (Cart) getSession().save(cart);
	}

}
