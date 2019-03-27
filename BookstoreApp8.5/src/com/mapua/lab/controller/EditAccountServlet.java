package com.mapua.lab.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mapua.lab.model.Customer;
import com.mapua.lab.model.CustomerDao;

/**
 * Servlet implementation class editAccountList
 */
@WebServlet("/EditAccountServlet")
public class EditAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String custId = request.getParameter("idnumber");
		String custUsernameEdit = request.getParameter("username");
		String custAddressEdit = request.getParameter("address");
		String custContactEdit = request.getParameter("contact");
		String custIPasswordEdit = request.getParameter("psw");
		String custUserTypeEdit = request.getParameter("usertype");
		
		
		Customer cust =  new Customer();
		cust.setCustomerId(custId);
		cust.setCustomerName(custUsernameEdit);
		cust.setCustomerAddress(custAddressEdit);
		cust.setCustomerContact(custContactEdit);
		cust.setCustomerPassword(custIPasswordEdit);
		cust.setLoginType(custUserTypeEdit);
		
		CustomerDao dao =  new CustomerDao();
		boolean result = dao.updateUser(cust);
		
		
		if (result == true) {
			RequestDispatcher dis = request.getRequestDispatcher("accountList.jsp");
			dis.forward(request, response);
		} else {
			response.setContentType("text/html;charset=UTF-8");
		    PrintWriter out = response.getWriter();
		    out.println("<script type=\"text/javascript\">");
		    out.println("alert('Edit Error');");
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
