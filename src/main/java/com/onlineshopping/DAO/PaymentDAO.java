package com.onlineshopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.onlineshopping.Connection.DBConnection;
import com.onlineshopping.model.Payment;

public class PaymentDAO {
	public boolean savePayment(Payment payment) {
		
		String query = "INSERT INTO payments(order_id,amount,method,status)VALUES(?,?,?,?)";
		
		try 
			(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query)){
			
			ps.setInt(1, payment.getOrderId());
			ps.setDouble(2, payment.getAmount());
			ps.setString(3, payment.getMethod());
			ps.setString(4, payment.getStatus());
			
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
}
