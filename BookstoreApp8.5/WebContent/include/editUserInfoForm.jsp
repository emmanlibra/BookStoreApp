<!-- Sign-up Form -->
<%@ page import="com.mapua.lab.model.CustomerDao" %>
<%@ page import="com.mapua.lab.model.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/load_account_details.jsp" />
<c:set var = "cust" scope = "session" value = "${accountdetails}"/>

<c:if test ="${param.name != null }"><c:set var="style" value="block"/></c:if>
<div id="editUserInfo" class="modal" style="display:${style}" >

  <form class="modal-content animate" action="EditAccountServlet" >
    <div class="container">
      <h1>Edit Information</h1>
      <hr>
      
      <label for="id" ><b>Id Number: ${cust.customerId}</b></label>
      <input type="hidden"  name="idnumber" value="${cust.customerId}"> 
      <hr>
      
      <label for="username"><b>User name</b></label>
      <input type="text" placeholder="Enter Username" name="username" value="${cust.customerName}" required>      
      
      <label for="email"><b>Address</b></label>
      <input type="text" placeholder="Enter Address" name="address" value="${cust.customerAddress}" style="width: 100%;  padding: 12px 20px;  margin: 8px 0;  display: inline-block;  border: 1px solid #ccc;  box-sizing: border-box;" required>

      <label for="contact"><b>Contact</b></label>
      <input type="text" placeholder="Enter Contact Number" name="contact" value="${cust.customerContact}" style="width: 100%;  padding: 12px 20px;  margin: 8px 0;  display: inline-block; border: 1px solid #ccc;  box-sizing: border-box;" required>

      <label for="psw"><b>Password</b></label>
      <input type="text" placeholder="Enter Password" id="password" name="psw" value="${cust.customerPassword}" required>
      
      <label for="usertype"><b>User Type</b></label> 
	  <select id="soflow" name="usertype">
	  	  <option value="admin_user" selected="selected" >Admin User</option>
		  <option value="customer_user" >Customer User</option>
	  </select>
      <div class="clearfix">
        <button type="button" onclick="document.getElementById('editUserInfo').style.display='none'" class="cancelbtn2">Cancel</button>
        <button type="submit" class="signupbtn">Update</button>
      </div>
    </div>
  </form>
</div>


