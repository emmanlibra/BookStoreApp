<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    
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
<title>Book Inventory</title>
<link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet" >
</head>
<body>
<jsp:include page="include/header.jsp" />
<%-- <%@include file="include/header.jsp" %> --%>

<%
CustomerDao validUser = new CustomerDao();
if (!validUser.validateAdminType((String) session.getAttribute(Utils.USER_SESSION))) {
	
	response.sendRedirect("bookCatalog.jsp");
	System.out.println("this is header!");
}
%>

<div class="topnav">
  <a href="addBookForm.jsp">Add Book to the Catalog</a>
  <a class="active" href="bookInventory.jsp">Book Inventory</a>
  <a href="accountList.jsp">List of Account</a>
</div>

<table  class="fixed_headers" border="1" style="display:table-cell;">

<%--Table Header --%>
<thead>
	<tr>
		<th>Book Id</th>
		<th>Book Name</th>
		<th>Book Description</th>
		<th>Book Author</th>
		<th>Book Price</th>
		<th>Number of Stock</th>
		<th colspan="2">Actions</th>
	</tr>
</thead>
	<tbody>
	<%--Loop for the contents --%>
		<jsp:include page="/book_list.jsp" />
		<c:forEach var="book" items="${sessionScope.listOfBooks}">
			<tr>
				<td>${book.id}</td>
				<td>${book.name}</td>
				<td>${book.description}</td>
				<td>${book.author}</td>
				<td style="text-align: right;">
						<fmt:setLocale value = "en_US"/>
	         			<fmt:formatNumber value = "${book.price}" type = "currency"/>
				</td>
				<td style="text-align: right;"> ${book.stock}</td>
				<td><button onclick="window.location.href='bookInventory.jsp?bookIdNo=${book.id}';">Edit</button></td>
				<td><button style="background-color: #f44336;" onclick="window.location.href='RemoveBookServlet?bookId=${book.id}';">Delete</button></td>
			</tr>
		</c:forEach>	

	</tbody>
</table>

<jsp:include page="include/editBookInventoryForm.jsp" />

</body>

<script>
// Get the modal
var modal = document.getElementById('editBookInfo');
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
</html>