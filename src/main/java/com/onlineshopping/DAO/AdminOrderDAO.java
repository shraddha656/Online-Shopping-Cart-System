package com.onlineshopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.onlineshopping.Connection.DBConnection;
import com.onlineshopping.model.AdminOrderView;

public class AdminOrderDAO {

	 public List<AdminOrderView> getAllOrders() {

	        List<AdminOrderView> list = new ArrayList<>();

//	        LEFT JOIN payments — because COD orders sometimes may not have an entry
//	        If payment status = null → show "Pending"
	        
	        String sql = 
	        "SELECT o.order_id, o.total_amount, o.payment_type, " +
	        "a.fullname, a.mobile, a.city, " +
	        "p.status " +
	        "FROM orders o " +
	        "JOIN address a ON o.address_id = a.id " +
	        "LEFT JOIN payments p ON o.order_id = p.order_id " +
	        "ORDER BY o.order_id DESC";

	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {

	                list.add(new AdminOrderView(
	                    rs.getInt("order_id"),
	                    rs.getString("fullname"),
	                    rs.getString("mobile"),
	                    rs.getString("city"),
	                    rs.getDouble("total_amount"),
	                    rs.getString("payment_type"),
	                    rs.getString("status") == null ? "Pending" : rs.getString("status")
	                ));
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	    }
}
