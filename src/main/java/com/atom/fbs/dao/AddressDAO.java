package com.atom.fbs.dao;

import java.util.List;

import com.atom.fbs.dto.Address;

public interface AddressDAO {

	Address getAddress(int addressId);
	void addAddress(Address address);
	void updateAddress(Address address);
	Address getBillingAddress(int userId);
	List<Address> listShippingAddresses(int userId);

}
