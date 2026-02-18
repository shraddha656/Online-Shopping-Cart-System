package com.onlineshopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlineshopping.Connection.DBConnection;
import com.onlineshopping.model.Products;

public class ProductDAO {

	public List<Products> getAllProducts() {
		List<Products> productlist = new ArrayList<>();
		String query = "SELECT * FROM products";

		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Products p = new Products();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescription(rs.getString("description"));
				p.setPrice(rs.getDouble("price"));
				p.setCategory(rs.getString("category"));
				p.setQuantity(rs.getInt("quantity"));
				p.setImage(rs.getString("image"));
				productlist.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productlist;
	}

	public boolean addProduct(Products p) {

		String query = "INSERT INTO products(name, description, price, category, quantity, image) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {

			ps.setString(1, p.getName());
			ps.setString(2, p.getDescription());
			ps.setDouble(3, p.getPrice());
			ps.setString(4, p.getCategory());
			ps.setInt(5, p.getQuantity());
			ps.setString(6, p.getImage());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean deleteProduct(int id) {
		String sql = "DELETE FROM products WHERE id=?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Products getProductById(int id) {
		
		Products p = null;
		String query = "SELECT * FROM products WHERE id = ?";
		
		try(
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query)){
					
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				p = new Products();
				p.setId(rs.getInt("id"));
			    p.setName(rs.getString("name"));
			    p.setDescription(rs.getString("description"));
			    p.setPrice(rs.getDouble("price"));
			    p.setCategory(rs.getString("category"));
			    p.setQuantity(rs.getInt("quantity"));
			    p.setImage(rs.getString("image"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
		
	}

	public List<Products> searchProducts(String keyword) {
		
		List<Products>list = new ArrayList<>();
		
		try {
			String query = "SELECT * FROM products WHERE name LIKE ? OR category LIKE ?";
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "%"+keyword+"%");
			ps.setString(2, "%"+keyword+"%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Products p = new Products();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
			    p.setDescription(rs.getString("description"));
			    p.setPrice(rs.getDouble("price"));
			    p.setCategory(rs.getString("category"));
			    p.setQuantity(rs.getInt("quantity"));
			    p.setImage(rs.getString("image"));

			    list.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Products> getProductsByCategory(String category) {

	    List<Products> list = new ArrayList<>();

	    String query = "SELECT * FROM products WHERE category LIKE ?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(query)) {

	        ps.setString(1, "%" + category + "%");
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Products p = new Products();
	            p.setId(rs.getInt("id"));
	            p.setName(rs.getString("name"));
	            p.setDescription(rs.getString("description"));
	            p.setPrice(rs.getDouble("price"));
	            p.setCategory(rs.getString("category"));
	            p.setQuantity(rs.getInt("quantity"));
	            p.setImage(rs.getString("image"));
	            list.add(p);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}


}
