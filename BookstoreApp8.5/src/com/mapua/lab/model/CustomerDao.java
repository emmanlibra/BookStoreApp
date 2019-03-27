package com.mapua.lab.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDao {

	/**
	 * Generate a connection
	 * @return connection
	 */
		public Connection getConnection() {
		
		System.out.println("Connecting database...");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			String dbName = System.getProperty("RDS_DB_NAME");
//		    String userName = System.getProperty("RDS_USERNAME");
//		    String password = System.getProperty("RDS_PASSWORD");
//		    String hostname = System.getProperty("RDS_HOSTNAME");
//		    String port = System.getProperty("RDS_PORT");
//		    String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
			
			String jdbcUrl = System.getProperty("JDBC_CONNECTION_STRING");
			System.out.println(jdbcUrl);
		    Connection conn = DriverManager.getConnection(jdbcUrl);
		    
			System.out.println("Connection Successful!");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cannot connect to the database!");
		}
		return null;
	}
		
	public boolean validateCustomer(String customerName, String customerPassword) {
		
		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customers where customer_name = '" + customerName + "' AND customer_password = '" + customerPassword + "'");

			if (rs.next()) {

				con.close();
				return true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in validating customer");
			return false;
		}
		
		return false;
	}
	
	public boolean validateAdmin(String customerName, String customerPassword) {
		
		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customers where customer_name = '" + customerName + "' AND customer_password = '" + customerPassword + "' AND login_type = 'admin_user'");
			if (rs.next()) {
				con.close();
				return true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in validating customer");
			return false;
		}
		
		return false;
	}
	
	public boolean validateAdminType(String customerName) {
		
		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customers where customer_name = '" + customerName + "' AND login_type = 'admin_user'");
			if (rs.next()) {
				con.close();
				return true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in validating customer");
			return false;
		}
		
		return false;
	}
	
	public boolean addNewUser(Customer cust) {
		
		try {
		Connection con = getConnection();
		
			String insertString = "INSERT INTO customers (customer_id, customer_name, customer_address, customer_contact, customer_password, login_type) VALUES (?,?,?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(insertString);
			pstm.setString(1, cust.generateCustomerId());
			pstm.setString(2, cust.getCustomerName());
			pstm.setString(3, cust.getCustomerAddress());
			pstm.setString(4, cust.getCustomerContact());
			pstm.setString(5, cust.getCustomerPassword());
			pstm.setString(6, cust.getCustomerType());
			
			int ret = pstm.executeUpdate();
			if(ret>0) {
				con.close();
				return true;
			} else {
				con.close();
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in inserting new user");
			return false;
		}
		
	}
	
	public boolean addNewUserFromAdmin(Customer cust) {
		
		try {
		Connection con = getConnection();
		
			String insertString = "INSERT INTO customers (customer_id, customer_name, customer_address, customer_contact, customer_password, login_type) VALUES (?,?,?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(insertString);
			pstm.setString(1, cust.generateCustomerId());
			pstm.setString(2, cust.getCustomerName());
			pstm.setString(3, cust.getCustomerAddress());
			pstm.setString(4, cust.getCustomerContact());
			pstm.setString(5, cust.getCustomerPassword());
			pstm.setString(6, cust.getLoginType());
			
			int ret = pstm.executeUpdate();
			if(ret>0) {
				con.close();
				return true;
			} else {
				con.close();
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in inserting new user");
			return false;
		}
		
	}
	
	public ArrayList<Customer> getAllUsers() {
		try {
			Connection con = getConnection();
			Statement stm = con.createStatement();
			String strSelect = "SELECT * from customers";
			
			ResultSet rs = stm.executeQuery(strSelect);
			ArrayList<Customer> listOfBooks = new ArrayList<Customer>();
			
			while(rs.next()) {
				Customer cust = new Customer();
				cust.setCustomerId(rs.getString("customer_id"));
				cust.setCustomerName(rs.getString("customer_name"));
				cust.setCustomerPassword(rs.getString("customer_password"));
				cust.setCustomerAddress(rs.getString("customer_address"));
				cust.setCustomerContact(rs.getString("customer_contact"));
				cust.setLoginType(rs.getString("login_type"));
				listOfBooks.add(cust);
			}
			con.close();
			return listOfBooks;
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
			return null;
		}
	}
	
	public boolean deleteUser(String cust) {
		
		try {
		Connection con = getConnection();
		
			String insertString = "DELETE FROM customers WHERE customer_id = "+ cust +";";
			PreparedStatement pstm = con.prepareStatement(insertString);

			int ret = pstm.executeUpdate();
			if(ret>0) {
				con.close();
				return true;
			} else {
				con.close();
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in deleting user");
			return false;
		}
		
	}
	
	public Customer getSpecificUser(String customerId) {
		
		Customer cust = new Customer();
		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customers where customer_id = '" + customerId + "'");
			if (rs.next()) {
				cust.setCustomerId(rs.getString("customer_id"));
				cust.setCustomerName(rs.getString("customer_name"));
				cust.setCustomerPassword(rs.getString("customer_password"));
				cust.setCustomerAddress(rs.getString("customer_address"));
				cust.setCustomerContact(rs.getString("customer_contact"));
				cust.setLoginType(rs.getString("login_type"));

				con.close();
				return cust;
			} 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getting customer details");
			return cust;
		}	
		return cust;
	}
	
	public boolean updateUser(Customer cust) {
		
		try {
			Connection con = getConnection();
			
				String insertString = "UPDATE customers SET customer_name = ?, customer_address =?, customer_contact=?, customer_password=?, login_type=? WHERE customer_id=?";
				PreparedStatement pstm = con.prepareStatement(insertString);
				pstm.setString(1, cust.getCustomerName());
				pstm.setString(2, cust.getCustomerAddress());
				pstm.setString(3, cust.getCustomerContact());
				pstm.setString(4, cust.getCustomerPassword());
				pstm.setString(5, cust.getLoginType());
				pstm.setString(6, cust.getCustomerId());
				
				System.out.println("Updated data");
				int ret = pstm.executeUpdate();
				if(ret>0) {
					con.close();
					return true;
				} else {
					con.close();
					return false;
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error in updating user");
				return false;
			}
	}
}
