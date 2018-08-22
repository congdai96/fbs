package com.atom.fbs.services.impl;

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
	public Address createAddress(Address address) {
		logger.info("Address Service - start create method");
		try {
			return addressDAO.addAddress(address);
		} catch (Exception e) {
			logger.error("create Address:", e);
			throw e;
		}
	}

}
