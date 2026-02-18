package com.onlineshopping.service;

import java.util.List;

import com.onlineshopping.DAO.AdminProductDAO;
import com.onlineshopping.model.Products;

public class AdminProductService {
	
	AdminProductDAO dao = new AdminProductDAO();
	
	public List<Products>getAllProducts(){
		return dao.getAllProducts();
	}
	
	public boolean addProduct(Products p) {
		return dao.addProduct(p);
	}
	
	public boolean updateProduct(Products p) {
		return dao.updateProduct(p);
	}
	
	public boolean deleteProduct(int id) {
		return dao.deleteProduct(id);
	}
	
	public Products getProductsById(int id) {
		return dao.getProductById(id);
	}
}
