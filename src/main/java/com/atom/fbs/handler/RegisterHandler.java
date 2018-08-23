package com.atom.fbs.handler;

import org.springframework.beans.factory.annotation.Autowired;





import org.springframework.stereotype.Component;

import com.atom.fbs.model.RegisterModel;
import com.atom.fbs.services.UserService;
import com.atom.fbs.services.AddressService;
import com.atom.fbs.dto.Address;
import com.atom.fbs.dto.Cart;
import com.atom.fbs.dto.User;


@Component
public class RegisterHandler {
	
@Autowired
private UserService userSERVICE;
private AddressService addressSERVICE;


 public RegisterModel init() { 
  return new RegisterModel();
 	} 
 public void addUser(RegisterModel registerModel, User user) {
	  registerModel.setUser(user);
 	}
 public void addBilling(RegisterModel registerModel, Address billing) {
	  registerModel.setBilling(billing);
	}
 public String saveAll(RegisterModel registerModel) {
	  String transitionValue = "success";
	  User user = registerModel.getUser();
	  if(user.getRole().equals("USER")) {
	   // create a new cart
	   Cart cart = new Cart();
	   cart.setUser(user);
	   user.setCart(cart);
	  }
	  
	  userSERVICE.add(user);
	  // save the billing address
	  Address billing = registerModel.getBilling();
	  billing.setUserId(user.getId());
	  billing.setBilling(true);  
	  addressSERVICE.addAddress(billing);
	  return transitionValue ;
 	}
}
