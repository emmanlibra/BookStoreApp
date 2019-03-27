<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mapua.lab.model.BookServiceDao" %>
<%@ page import="com.mapua.lab.model.Book" %>
<%@ page import="com.mapua.lab.model.CustomerDao" %>
<%@ page import="com.mapua.lab.model.Customer" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="com.mapua.lab.model.Utils" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Shopping Cart List</title>
<link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet" >
</head>
<body>
<%-- <jsp:include page="include/header.jsp" /> --%>
<%@include file="include/header.jsp" %>

<div class="topnav">
  <a href="bookCatalog.jsp">Book Catalog</a>
  <a class="active" href="showShoppingCart.jsp">Shopping Cart</a>
</div>

<c:choose>
	<c:when  test="${booklist.size() == 0 || booklist == null }">
		<h3>There is no item in your shopping cart!</h3>	
	</c:when>
	<c:otherwise> 
		<table class="fixed"  border="1" >
			<col width="150px" />
		    <col width="300px" />
		    <col width="100px" />
		    <col width="250px" />
				 
			<th>Book Id</th>
			<th>Book Name</th>
			<th>Price</th>
			<th>Actions</th>
			
			<c:set var="count" value="0" scope="page" />			
			<c:forEach var="book" items="${sessionScope.booklist}">
				<tr>
					<td>${book.id}</td>
					<td>${book.name}</td>
					<td style="text-align: right;">
						<fmt:setLocale value = "en_US"/>
	         			<fmt:formatNumber value = "${book.price}" type = "currency"/>
					</td>
					<td style="text-align: center;"><a href="RemoveFromShoppingCartServlet?bookId=${book.id}&bookItemNo=<c:set var="count" value="${count + 1}" scope="page"/>">Remove from Shopping Cart</a></td>
				</tr>
			</c:forEach>
	
				<tr>
					<td colspan="2" style="text-align: center;"> Total:  </td>
					<td style="text-align: right;"><%-- <%=(Double)session.getAttribute(Utils.TOTAL_PRICE) %> --%>
					<fmt:setLocale value = "en_US"/>
		         	<fmt:formatNumber value ='${sessionScope[Utils.TOTAL_PRICE]}' type = "currency"/>
					</td>
					<td></td>
				</tr>
		</table>
</c:otherwise>  
</c:choose>
<br/>
<a href="bookCatalog.jsp">&#x21A9;Go Back to Catalog</a>

</body>
</html>