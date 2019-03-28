package com.mapua.lab.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mapua.lab.model.Book;
import com.mapua.lab.model.Utils;

/**
 * Servlet implementation class AddToShoppingCartServlet
 */
@WebServlet("/AddToShoppingCartServlet")
public class AddToShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bookIdAdded = request.getParameter("bookId");
		String bookNameAdded = request.getParameter("bookName");
		double bookPriceadded = Double.parseDouble(request.getParameter("bookPrice"));
		
		Book bookOrder = new Book();
		bookOrder.setId(bookIdAdded);
		bookOrder.setName(bookNameAdded);
		bookOrder.setPrice(bookPriceadded);
		
		HttpSession session = request.getSession();

		ArrayList<Book> listOfCart = (ArrayList<Book>) session.getAttribute(Utils.SHOPPING_CART_SESSION);
		listOfCart.add(bookOrder);
		
		System.out.println("added to cart session");
		session.setAttribute("booklist", listOfCart);
		
		Double totalPrice = (Double) session.getAttribute(Utils.TOTAL_PRICE);
		totalPrice = totalPrice + bookOrder.getPrice();
		
		 session.setAttribute(Utils.TOTAL_PRICE, totalPrice); 
		/* session.setAttribute("total", totalPrice); */ 
		
		RequestDispatcher dis = request.getRequestDispatcher("showShoppingCart.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
