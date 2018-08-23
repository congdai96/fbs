package com.atom.fbs.services;

import java.util.List;

import com.atom.fbs.dto.Address;

public interface AddressService {
	Address getAddress(int addressId) throws Exception;
	boolean addAddress(Address address);
	boolean updateAddress(Address address) throws Exception;
	Address getBillingAddress(int userId) throws Exception;
	List<Address> listShippingAddresses(int userId);

}
