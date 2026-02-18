package com.onlineshopping.DAO;

import java.net.Authenticator.RequestorType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlineshopping.Connection.DBConnection;
import com.onlineshopping.model.User;

public class UserDAO {

	public boolean register(User user) {
		String query = "INSERT INTO users(name,email,password,role) VALUES (?,?,?,?)";
		
		try(
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query)){
			
			ps.setString(1,user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getRole());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public User login(String email, String password) {
		String query = "SELECT * FROM users WHERE email = ? AND password = ?";
		
		try (
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query)){
			
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<User> getAllUsers(){
		List<User>list = new ArrayList<>();
		String query = "SELECT * FROM users";
		
		try 
			(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery()){
			
			while(rs.next()) {
				User u = new User();
				 u.setUserId(rs.getInt("user_id"));
			     u.setName(rs.getString("name"));
			     u.setEmail(rs.getString("email"));
			     u.setPassword(rs.getString("password"));
			     u.setRole(rs.getString("role"));
			     
			     list.add(u);
			}
			
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
