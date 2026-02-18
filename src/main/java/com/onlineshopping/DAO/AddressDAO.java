package com.onlineshopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.onlineshopping.Connection.DBConnection;
import com.onlineshopping.model.Address;

public class AddressDAO {
	public int save(Address a) {
		int addressId = 0;
		
		String query = "INSERT INTO address (user_id,fullname,mobile,address,city,pincode)VALUES(?,?,?,?,?,?)";
		
		try (Connection con = DBConnection.getConnection()){
			
			PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, a.getUserId());
			ps.setString(2, a.getFullName());
			ps.setString(3, a.getMobile());
			ps.setString(4, a.getAddress());
			ps.setString(5, a.getCity());
			ps.setString(6, a.getPincode());
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				addressId = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return addressId;
		
	}
}
