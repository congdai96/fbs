package com.atom.fbs.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.atom.fbs.dao.AddressDAO;
import com.atom.fbs.dto.Address;

@Repository("addressDAO")
public class AddressDAOImpl implements AddressDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return (Session) sessionFactory.getCurrentSession();
	}


	@Override
	public Address getAddress(int addressId) {			
			return (Address) getSession().get(Address.class, addressId);			

	}

	@Override
	public void addAddress(Address address) {
		getSession().persist(address);			
				
	}
	
	@Override
	public void updateAddress(Address address) {			
		 getSession().update(address);			
	}
	
	@Override
	public Address getBillingAddress(int userId) {
		String selectQuery = "FROM Address WHERE userId = :userId AND billing = :isBilling";
		return (Address)
				getSession().createQuery(selectQuery,Address.class)
						.setParameter("userId", userId)
						.setParameter("isBilling", true)
						.getSingleResult();
	}
	
	@Override
	public List<Address> listShippingAddresses(int userId) {
		String selectQuery = "FROM Address WHERE userId = :userId AND shipping = :isShipping ORDER BY id DESC";
		return getSession()
					.createQuery(selectQuery,Address.class)
						.setParameter("userId", userId)
						.setParameter("isShipping", true)
							.getResultList();
		
	}
}
