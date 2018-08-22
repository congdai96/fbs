package com.atom.fbs.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.atom.fbs.dao.AddressDAO;
import com.atom.fbs.dto.Address;

@Repository("addressDAO")
public class AddressDAOImpl extends HibernateDaoSupport implements AddressDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return (Session) sessionFactory.getCurrentSession();
	}

	@Override
	public Address addAddress(Address address) {
		return (Address) getSession().save(address);
	}

}
