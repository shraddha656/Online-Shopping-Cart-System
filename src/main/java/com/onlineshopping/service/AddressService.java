package com.onlineshopping.service;

import com.onlineshopping.DAO.AddressDAO;
import com.onlineshopping.model.Address;

public class AddressService {
	
	AddressDAO dao = new AddressDAO();
	
	public int saveAddess(Address address) {
		
		return dao.save(address);
	}

}
