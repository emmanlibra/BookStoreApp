package com.mapua.lab.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BookServiceDao {
	
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
		
		/**
		 * Add a book data to the database...
		 * @return true is the data is successfully added to the database
		 */
	public boolean addBookToTheDatabase(Book book) {
		
		try {
			Connection con = getConnection();
			
			String insertString = "INSERT INTO books (book_id, book_name, book_description, book_author, price, number_of_stock) VALUES (?,?,?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(insertString);
			pstm.setString(1, book.generateBookId());
			pstm.setString(2, book.getName());
			pstm.setString(3, book.getDescription());
			pstm.setString(4, book.getAuthor());
			pstm.setDouble(5, book.getPrice());
			pstm.setInt(6, book.getStock());
			
			int ret = pstm.executeUpdate();
			
			if(ret>0) {
				con.close();
				return true;

			} else {
				con.close();
				return false;
			}

		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Data is not added to the database");
			return false;
		}
	}
	
	public ArrayList<Book> getAllBooks() {
		try {
			Connection con = getConnection();
			Statement stm = con.createStatement();
			String strSelect = "SELECT * from books";
			ResultSet rs = stm.executeQuery(strSelect);
			ArrayList<Book> listOfBooks = new ArrayList<Book>();
			
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getString("book_id"));
				book.setName(rs.getString("book_name"));
				book.setDescription(rs.getString("book_description"));
				book.setAuthor(rs.getString("book_author"));
				book.setPrice(rs.getDouble("price"));
				book.setStock(rs.getInt("number_of_stock"));
				listOfBooks.add(book);
			}
			con.close();
			return listOfBooks;
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
			return null;
		}
	}
	
	public boolean deleteBook(String book) {
		
		try {
		Connection con = getConnection();
		
			String insertString = "DELETE FROM books WHERE book_id = "+ book +";";
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
			System.out.println("Error in deleting book");
			return false;
		}
		
	}
	
	public Book getSpecificBook(String bookId) {
		
		Book book = new Book();
		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from books where book_id = '" + bookId + "'");
			if (rs.next()) {
				book.setId(rs.getString("book_id"));
				book.setName(rs.getString("book_name"));
				book.setDescription(rs.getString("book_description"));
				book.setAuthor(rs.getString("book_author"));
				book.setPrice(rs.getDouble("price"));
				book.setStock(rs.getInt("number_of_stock"));
				
				con.close();
				return book;
			} 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getting customer details");
			return book;
		}	
		return book;
	}
	
public boolean updateBook(Book book) {
		
		try {
			Connection con = getConnection();
			
				String insertString = "UPDATE books SET book_name = ?, book_description =?, book_author=?, price=?, number_of_stock=? WHERE book_id=?";
				PreparedStatement pstm = con.prepareStatement(insertString);
				pstm.setString(1, book.getName());
				pstm.setString(2, book.getDescription());
				pstm.setString(3, book.getAuthor());
				pstm.setDouble(4, book.getPrice());
				pstm.setInt(5, book.getStock());
				pstm.setString(6, book.getId());
				
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
				System.out.println("Error in updating book");
				return false;
			}
	}
	
	
}
