package com.mapua.lab.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mapua.lab.model.Book;
import com.mapua.lab.model.BookServiceDao;

/**
 * Servlet implementation class GetBookInventoryFromDataBaseServlet
 */
@WebServlet("/GetBookInventoryFromDataBaseServlet")
public class GetBookInventoryFromDataBaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBookInventoryFromDataBaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookServiceDao dao = new BookServiceDao();
		ArrayList<Book> listOfBooks = dao.getAllBooks();
		
		HttpSession session = request.getSession();
		session.setAttribute("listOfBooks", listOfBooks);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
