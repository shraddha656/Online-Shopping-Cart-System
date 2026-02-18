package com.onlineshopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlineshopping.Connection.DBConnection;
import com.onlineshopping.model.Products;
import com.sun.net.httpserver.Request;

public class AdminProductDAO {
	
	public List<Products> getAllProducts(){
		
	
	
		List<Products> list = new ArrayList<>();
		String query = "SELECT * FROM products";
		
		try 
		(Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery()){
		
		while(rs.next()) {
			Products p = new Products(
			rs.getInt("id"),
			rs.getString("name"),
			rs.getString("description"),
			rs.getDouble("price"),
			rs.getString("category"),
			rs.getInt("quantity"),
			rs.getString("image"));	
			
			list.add(p);
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
	}
	
	public boolean addProduct(Products p) {
		
		String query = "INSERT INTO products(name,description,price,category,quantity,image)VALUES(?,?,?,?,?,?)";
		
		try 
			(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query)){
			
			ps.setString(1, p.getName());
			ps.setString(2, p.getDescription());
			ps.setDouble(3, p.getPrice());
			ps.setString(4, p.getCategory());
			ps.setInt(5, p.getQuantity());
			ps.setString(6, p.getImage());
			
			return ps.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public boolean updateProduct(Products p) {
        String query = "UPDATE products SET name=?,description=?,price=?,category=?,quantity=?,image=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, p.getName());
            ps.setString(2, p.getDescription());
            ps.setDouble(3, p.getPrice());
            ps.setString(4, p.getCategory());
            ps.setInt(5, p.getQuantity());
            ps.setString(6, p.getImage());
            ps.setInt(7, p.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
	
	public boolean deleteProduct(int id) {
		
		String query = "DELETE FROM products WHERE id=?";
		try (
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query)){
			
			ps.setInt(1, id);
			return ps.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;	
	}

	public Products getProductById(int id) {
		
		Products p = null;
		
		String query = "SELECT * FROM products WHERE id = ?";
		
		try (
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query)){
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				p = new Products(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("description"),
						rs.getDouble("price"),
						rs.getString("category"),
						rs.getInt("quantity"),
						rs.getString("image")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
		
	}
}
