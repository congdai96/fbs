package com.atom.fbs.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atom.fbs.dao.CartDAO;
import com.atom.fbs.dto.Cart;
import com.atom.fbs.services.CartService;

@Transactional
@Service
public class CartServiceImpl implements CartService {
	private static final Logger logger = Logger.getLogger(CartServiceImpl.class);

	@Autowired
	private CartDAO cartDAO;

	@Override
	public Cart createCart(Cart cart) {
		logger.info("Cart Service - start create method");
		try {
			return cartDAO.addCart(cart);
		} catch (Exception e) {
			logger.error("create Cart:", e);
			throw e;
		}
	}

}
