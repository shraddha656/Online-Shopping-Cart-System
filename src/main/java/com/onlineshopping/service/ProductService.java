package com.onlineshopping.service;

import java.util.List;

import com.onlineshopping.DAO.ProductDAO;
import com.onlineshopping.model.Products;


public class ProductService {
	ProductDAO dao = new ProductDAO();
	
	public List<Products> getAllProducts(){
		return dao.getAllProducts();
	}
	
	boolean addProduct(Products p) {
		return dao.addProduct(p);
	}
	
	boolean deleteProduct(int id) {
        return dao.deleteProduct(id);
    }
	
	public Products getProductById(int id) {
		return dao.getProductById(id);
	}

	public List<Products> searchProducts(String keyword) {
		
		return dao.searchProducts(keyword);
	}
	
	public List<Products> getProductsByCategory(String category) {
	    return dao.getProductsByCategory(category);
	}

}
