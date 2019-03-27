package com.mapua.lab.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mapua.lab.model.Customer;
import com.mapua.lab.model.CustomerDao;

/**
 * Servlet implementation class GetAccountListFromDataBase
 */
@WebServlet("/GetAccountListFromDataBaseServlet")
public class GetAccountListFromDataBaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAccountListFromDataBaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerDao dao = new CustomerDao();
		ArrayList<Customer> listOfUsers = dao.getAllUsers();
		
		HttpSession session = request.getSession();
		session.setAttribute("listOfUsers", listOfUsers);
		
		
//		RequestDispatcher dis = request.getRequestDispatcher("showShoppingCart.jsp");
//		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
