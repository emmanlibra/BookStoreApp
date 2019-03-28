<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mapua.lab.model.BookServiceDao" %>
<%@ page import="com.mapua.lab.model.Book" %>
<%@ page import="com.mapua.lab.model.CustomerDao" %>
<%@ page import="com.mapua.lab.model.Customer" %>
<%@ page import="com.mapua.lab.model.Utils" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bookstore Application</title>
<link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet" >
</head>
<body>
<jsp:include page="include/header.jsp" />
<%-- <%@include file="include/header.jsp" %> --%>

<%
CustomerDao validUser = new CustomerDao();
if (!validUser.validateAdminType((String) session.getAttribute(Utils.USER_SESSION))) {
	System.out.println("this is addbookform");
	response.sendRedirect("bookCatalog.jsp");
}
%>

<div class="topnav">
  <a class="active" href="addBookForm.jsp">Add Book to the Catalog</a>
  <a href="bookInventory.jsp">Book Inventory</a>
  <a href="accountList.jsp">List of Account</a>
</div>


<hr/>

<form name="AddBookForm" method="post" action="AddBookServlet">

<table>
	<tr>
		<td>Book Name:</td>
		<td><input type="text" size="100"  name="book_name" required/></td>
	</tr>
	<tr>
		<td>Book Description:</td>
		<td><input type="text" size="100"  name="book_desccription" /></td>
	</tr>	
	<tr>
		<td>Author:</td>
		<td><input type="text" size="100"  name="book_author" /></td>
	</tr>	
	<tr>
		<td>Price:</td>
		<td><input type="text" size="100"  name="book_price" required/></td>
	</tr>
	<tr>
		<td>Stock:</td>
		<td><input type="text" size="100"  name="book_stock" required/></td>
	</tr>
	<tr>
		<td></td>
		<td><button type="submit" >Add Book to the Database</button><br/></td>
	</tr>

</table>

</form>

</body>
</html>