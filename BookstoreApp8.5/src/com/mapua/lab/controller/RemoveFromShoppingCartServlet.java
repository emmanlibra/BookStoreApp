package com.mapua.lab.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
 * Servlet implementation class RemoveFromShoppingCartServlet
 */
@WebServlet("/RemoveFromShoppingCartServlet")
public class RemoveFromShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bookIdDelete = request.getParameter("bookId");
		
		HttpSession session = request.getSession();
		ArrayList<Book> listOfCart = (ArrayList<Book>) session.getAttribute(Utils.SHOPPING_CART_SESSION);
		
		for (int i = 0; i<listOfCart.size(); i++) {
			Book book = listOfCart.get(i);
			if (book.getId().equals(bookIdDelete)) {
				listOfCart.remove(i);
			
				Double totalPrice = (Double) session.getAttribute(Utils.TOTAL_PRICE);
				totalPrice = totalPrice - book.getPrice();
				session.setAttribute(Utils.TOTAL_PRICE, totalPrice);
			}
		}
		
		session.setAttribute("booklist", listOfCart);
	
//		listOfCart.removeIf((e -> e.getId().equals(bookIdDelete)));
//		System.out.println("deleted to session");
//		
//		Book bookOrder = new Book();
//		bookOrder.setPrice(bookPriceDelete);
//		
//		Double totalPrice = (Double) session.getAttribute(Utils.TOTAL_PRICE);
//		totalPrice = totalPrice - bookOrder.getPrice();
//		session.setAttribute(Utils.TOTAL_PRICE, totalPrice);s
		RequestDispatcher dis = request.getRequestDispatcher("showShoppingCart.jsp");
		dis.forward(request, response);
//		response.sendRedirect("showShoppingCart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
