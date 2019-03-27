package com.mapua.lab.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mapua.lab.model.BookServiceDao;
import com.mapua.lab.model.CustomerDao;

/**
 * Servlet implementation class RemoveBookServlet
 */
@WebServlet("/RemoveBookServlet")
public class RemoveBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bookIdDelete = request.getParameter("bookId");
		
		
		BookServiceDao book = new BookServiceDao();
		boolean result = book.deleteBook(bookIdDelete);
		
		if (result == true)  {
			RequestDispatcher dis = request.getRequestDispatcher("bookInventory.jsp");
			dis.forward(request, response);
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
