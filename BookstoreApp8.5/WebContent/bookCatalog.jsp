<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mapua.lab.model.BookServiceDao" %>
<%@ page import="com.mapua.lab.model.Book" %>
<%@ page import="com.mapua.lab.model.CustomerDao" %>
<%@ page import="com.mapua.lab.model.Customer" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Catalog</title>
<link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet" >
</head>
<body>
<%-- <jsp:include page="include/header.jsp" /> --%>
<%@include file="include/header.jsp" %>

<div class="topnav">
  <a class="active" href="bookCatalog.jsp">Book Catalog</a>
  <a href="showShoppingCart.jsp">Shopping Cart</a>
</div>

<table class="fixed" border="1">

    <col width="150px" />
    <col width="300px" />
    <col width="300px" />
    <col width="300px" />
    <col width="100px" />
    <col width="200px" />
    
<%--Table Header --%>
<thead>
	<th>Book Id</th>
	<th>Book Name</th>
	<th>Book Description</th>
	<th>Book Author</th>
	<th>Book Price</th>
	<th>Book Actions</th>
</thead>

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
		<td style="text-align: center;"> <a href="AddToShoppingCartServlet?bookId=${book.id}&bookName=${book.name}&bookPrice=${book.price}">Add to Shopping Cart</a></td>
			</tr>
		</c:forEach>

</table>

</body>
</html>