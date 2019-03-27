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
 * Servlet implementation class RemoveFromAccountList
 */
@WebServlet("/RemoveFromAccountList")
public class RemoveFromAccountList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromAccountList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String custIdDelete = request.getParameter("custId");
		
		
		CustomerDao dao = new CustomerDao();
		boolean result = dao.deleteUser(custIdDelete);
		
		if (result == true)  {
			
			RequestDispatcher dis = request.getRequestDispatcher("accountList.jsp");
			dis.forward(request, response);
//		    response.setContentType("text/html;charset=UTF-8");
//		    PrintWriter out = response.getWriter();
//		    out.println("<script type=\"text/javascript\">");
//		    out.println("location='accountList.jsp'");
//		    out.println("</script>");
		} else {
		    response.setContentType("text/html;charset=UTF-8");
		    PrintWriter out = response.getWriter();
		    out.println("<script type=\"text/javascript\">");
		    out.println("alert('Not Deleted');");
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
