package com.onlineshopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlineshopping.Connection.DBConnection;
import com.onlineshopping.model.Order;
import com.onlineshopping.model.OrderItem;

public class OrderDAO {
	public int saveOrder(Order order) {
		
		int orderId = 0;
		
		String insertOrder = "INSERT INTO orders(user_id, total_amount, address_id, payment_type)VALUES (?, ?, ?, ?)";
		String insertItem = "INSERT INTO order_items(order_id, product_id, quantity, price)VALUES(?,?,?,?)";
		
		try(Connection con = DBConnection.getConnection())
		 {
			con.setAutoCommit(false);
			
			//insert into orders table
			PreparedStatement ps = con.prepareStatement(insertOrder,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, order.getUserId());
			ps.setDouble(2, order.getTotalAmount());  // order is pass in method.
			ps.setInt(3, order.getAddressId());
	        ps.setString(4, order.getPaymentType());

			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				orderId = rs.getInt(1);
			}
			else {
				System.out.println("ERROR:Order Id is not genarated.");
				return 0;
			}
			
			//insert items
			PreparedStatement psitem = con.prepareStatement(insertItem);
			for(OrderItem item: order.getItems()) {
				psitem.setInt(1, orderId);
				psitem.setInt(2, item.getProductId());
				psitem.setInt(3, item.getQuantity());
				psitem.setDouble(4, item.getPrice());
				psitem.addBatch();
			}
			
			 psitem.executeBatch();
	         con.commit();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("❌ SQL Error:");
			e.printStackTrace();
		}
		
		return orderId;
	}

	 public List<Order> getOrdersByUser(int userId) {
	        List<Order> orders = new ArrayList<>();

	        String sql = "SELECT * FROM orders WHERE user_id=? ORDER BY order_date DESC";

	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, userId);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                Order o = new Order();
	                o.setOrderId(rs.getInt("order_id"));
	                o.setUserId(rs.getInt("user_id"));
	                o.setAddressId(rs.getInt("address_id"));
	                o.setTotalAmount(rs.getDouble("total_amount"));
	                o.setPaymentType(rs.getString("payment_type"));

	                o.setItems(getItemsByOrderId(rs.getInt("order_id"))); // fetch order items

	                orders.add(o);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return orders;
	    }
	 
	 public List<OrderItem> getItemsByOrderId(int orderId) {

	        List<OrderItem> items = new ArrayList<>();

	        String sql = "SELECT * FROM order_items WHERE order_id=?";

	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, orderId);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                OrderItem item = new OrderItem();
	                item.setId(rs.getInt("id"));
	                item.setOrderId(rs.getInt("order_id"));
	                item.setProductId(rs.getInt("product_id"));
	                item.setQuantity(rs.getInt("quantity"));
	                item.setPrice(rs.getDouble("price"));

	                items.add(item);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return items;
	    }

	 public int saveSingleOrder(Order order) {
		 int orderId = 0;

		    String insertOrder = "INSERT INTO orders(user_id, total_amount, address_id, payment_type) VALUES (?, ?, ?, ?)";
		    String insertItem = "INSERT INTO order_items(order_id, product_id, quantity, price) VALUES(?,?,?,?)";

		    try (Connection con = DBConnection.getConnection()) {

		        con.setAutoCommit(false);

		        // Insert into orders table
		        PreparedStatement ps = con.prepareStatement(insertOrder, Statement.RETURN_GENERATED_KEYS);
		        ps.setInt(1, order.getUserId());
		        ps.setDouble(2, order.getTotalAmount());
		        ps.setInt(3, order.getAddressId());
		        ps.setString(4, order.getPaymentType());
		        ps.executeUpdate();

		        ResultSet rs = ps.getGeneratedKeys();
		        if (rs.next()) {
		            orderId = rs.getInt(1);
		        }

		        // Insert buy-now single item
		        OrderItem item = order.getItems().get(0);
		        PreparedStatement psItem = con.prepareStatement(insertItem);
		        psItem.setInt(1, orderId);
		        psItem.setInt(2, item.getProductId());
		        psItem.setInt(3, item.getQuantity());
		        psItem.setDouble(4, item.getPrice());
		        psItem.executeUpdate();

		        con.commit();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return orderId;
	 }
	
}
