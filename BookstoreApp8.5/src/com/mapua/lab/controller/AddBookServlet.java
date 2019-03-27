package com.mapua.lab.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mapua.lab.model.Book;
import com.mapua.lab.model.BookServiceDao;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Get parameters
		String bookName = request.getParameter("book_name");
		String bookDescription = request.getParameter("book_desccription");
		String bookAuthor = request.getParameter("book_author");
		double bookPrice = Double.parseDouble(request.getParameter("book_price"));
		int bookStock = Integer.parseInt(request.getParameter("book_stock"));
		
		
		//set parameter to Book model
		Book book =  new Book();
		book.setName(bookName);
		book.setDescription(bookDescription);
		book.setAuthor(bookAuthor);
		book.setPrice(bookPrice);
		book.setStock(bookStock);
		
		BookServiceDao dao = new BookServiceDao();
		boolean result = dao.addBookToTheDatabase(book);
		
		if (result == true) {
			RequestDispatcher dis = request.getRequestDispatcher("bookInventory.jsp");
			dis.forward(request, response);
			
		    response.setContentType("text/html;charset=UTF-8");
		    PrintWriter out = response.getWriter();
		    out.println("<script type=\"text/javascript\">");
		    out.println("alert('Book Added!');");
		    out.println("</script>");		
			
		} else {
			RequestDispatcher dis = request.getRequestDispatcher("bookInsertFail.jsp");
			dis.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
