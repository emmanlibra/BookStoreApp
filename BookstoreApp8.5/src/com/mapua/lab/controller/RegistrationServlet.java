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

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("username");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String password = request.getParameter("psw");
		
		HttpSession session = request.getSession();		
		
		Customer cust =  new Customer();
		cust.setCustomerName(name);
		cust.setCustomerAddress(address);
		cust.setCustomerContact(contact);
		cust.setCustomerPassword(password);
		
		boolean result = false;
		CustomerDao dao = new CustomerDao();
		if (session.getAttribute("theUserName") != null) {
			String userType = request.getParameter("usertype");
			cust.setLoginType(userType);
			result = dao.addNewUserFromAdmin(cust);	
		
		} else {
			result = dao.addNewUser(cust);	

		}
		
		System.out.println(cust.getCustomerType());
		
		if (result == true) {				
			
			if (dao.validateAdminType((String) session.getAttribute("theUserName")) == true){
				response.setContentType("text/html;charset=UTF-8");
			    PrintWriter out = response.getWriter();
			    out.println("<script type=\"text/javascript\">");
			    //out.println("alert('Added New Account Success!');");
			    out.println("location='accountList.jsp';");
			    out.println("</script>");	
				
			} else if (cust.getCustomerType().equals("customer_user")) {

				session.setAttribute("theUserName", name);
				System.out.println("session name");	
				
				ArrayList<Book> list = new ArrayList<Book>();
				session.setAttribute("cartItems", list);
				
			    response.setContentType("text/html;charset=UTF-8");
			    PrintWriter out = response.getWriter();
			    out.println("<script type=\"text/javascript\">");
			    //out.println("alert('Registration Success!');");
			    out.println("location='bookCatalog.jsp';");
			    out.println("</script>");		
				
				System.out.println("Registration Success!");
			}

//			RequestDispatcher dis = request.getRequestDispatcher("bookCatalog.jsp");
//			dis.forward(request, response);
			
		} else {
		    PrintWriter out = response.getWriter();
		    out.println("<script type=\"text/javascript\">");
		    out.println("alert('Registration Fail!');");
		    out.println("location='login.jsp';");
		    out.println("</script>");
//			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
//			dis.forward(request, response);
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
