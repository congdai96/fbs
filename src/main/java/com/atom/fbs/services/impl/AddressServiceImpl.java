package com.atom.fbs.services.impl;

import java.util.List;




import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atom.fbs.dao.AddressDAO;
import com.atom.fbs.dto.Address;
import com.atom.fbs.services.AddressService;

@Transactional
@Service
public class AddressServiceImpl implements AddressService{
	private static final Logger logger = Logger.getLogger(AddressServiceImpl.class);

	@Autowired
	private AddressDAO addressDAO;
	
	@Override
	public Address getAddress(int addressId) {
		try {			
			return addressDAO.getAddress(addressId);	
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public boolean addAddress(Address address) {
		try {			
			// will look for this code later and why we need to change it
			addressDAO.addAddress(address);			
			return true;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public boolean updateAddress(Address address) {
		try {			
			addressDAO.updateAddress(address);		
			return true;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public Address getBillingAddress(int userId) {
		try{
			return addressDAO.getBillingAddress(userId);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public List<Address> listShippingAddresses(int userId) {
		return addressDAO.listShippingAddresses(userId);
	}

}
