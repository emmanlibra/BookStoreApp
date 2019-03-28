package com.mapua.lab.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mapua.lab.model.Book;
import com.mapua.lab.model.Customer;
import com.mapua.lab.model.CustomerDao;
import com.mapua.lab.model.Utils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		session.setAttribute(Utils.USER_SESSION, username);
		
		ArrayList<Book> list = new ArrayList<Book>();
		session.setAttribute(Utils.SHOPPING_CART_SESSION, list);
		
		session.setAttribute(Utils.TOTAL_PRICE, new Double(0.00));
		
		CustomerDao custdao = new CustomerDao();
		
		if (custdao.validateAdmin(username, password) ==  true) {
					
			PrintWriter out = response.getWriter();
			out.println("Admin Login Sucessfully");
//			response.sendRedirect("addBookForm.jsp");
			RequestDispatcher dis = request.getRequestDispatcher("addBookForm.jsp");
			dis.forward(request, response);
			
		} else if (custdao.validateCustomer(username, password) == true  ) {
			
			RequestDispatcher dis = request.getRequestDispatcher("bookCatalog.jsp");
			dis.forward(request, response);
		} else {
			session.getAttribute(Utils.USER_SESSION);
			session.removeAttribute(Utils.USER_SESSION);
			session.invalidate();

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Username or password incorrect');");
			out.println("location='login.jsp';");
			out.println("</script>");
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
