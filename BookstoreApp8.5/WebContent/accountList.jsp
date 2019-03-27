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
<title>Account List</title>
<link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet" >
</head>
<body>
<jsp:include page="include/header.jsp" />
<%-- <%@include file="include/header.jsp" %> --%>

<%
CustomerDao validUser = new CustomerDao();
if (!validUser.validateAdminType((String) session.getAttribute(Utils.USER_SESSION))) {
	response.sendRedirect("bookCatalog.jsp");
}
%>

<div class="topnav">
  <a href="addBookForm.jsp">Add Book to the Catalog</a>
  <a href="bookInventory.jsp">Book Inventory</a>
  <a class="active" href="accountList.jsp">List of Account</a>
</div>

<hr/>

	<button onclick="document.getElementById('addbtn').style.display='block'" style="width:auto;float: right;margin-right:10px" >Add</button>
	<table class="fixed_headers" border="1" style="display:table-cell;">

	<%--Table Header --%>
	 <thead>
		 <tr>
			<th>Customer Id</th>
			<th>Customer Name</th>
			<th>Password</th>
			<th>Customer Address</th>
			<th>Customer Contact</th>
			<th>User Type</th>
			<th colspan="2">Actions</th>
		 </tr>
	 </thead>

	<tbody>
	<%--Loop for the contents --%>
		<jsp:include page="/account_list.jsp" />
		<c:forEach var="cust" items="${sessionScope.listOfUsers}">
			<tr>
				<td>${cust.customerId}</td>
				<td>${cust.customerName}</td>
				<td>${cust.customerPassword}</td>
				<td>${cust.customerAddress}</td>
				<td>${cust.customerContact}</td>
				<td>${cust.loginType}</td>
				<td><button onclick="window.location.href='accountList.jsp?name=${cust.customerId}';">Edit</button></td>
				<td><button style="background-color: #f44336;" onclick="window.location.href='RemoveFromAccountList?custId=${cust.customerId}';">Delete</button></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	
	<jsp:include page="include/editUserInfoForm.jsp" />
	<jsp:include page="include/addAccountForm.jsp" />

</body>
<script>
// Get the modal
var modal = document.getElementById('addbtn');
var modal2 = document.getElementById('editUserInfo');
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal || event.target == modal2) {
        modal.style.display = "none";
        modal2.style.display = "none";
    }
}
</script>


</html>