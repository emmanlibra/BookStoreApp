<!-- Sign-up Form -->
<%@ page import="com.mapua.lab.model.CustomerDao" %>
<%@ page import="com.mapua.lab.model.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/load_book_data.jsp" />
<c:set var = "book" scope = "session" value = "${bookdetails}"/>

<c:if test ="${param.bookIdNo != null }"><c:set var="style" value="block"/></c:if>
<div id="editBookInfo" class="modal" style="display:${style}" >

  <form class="modal-content animate" action="EditBookServlet" >
    <div class="container">
      <h1>Edit Information</h1>
      <hr>
      
      <label for="id" ><b>Book Id Number: ${book.id}</b></label>
      <input type="hidden"  name="book_id" value="${book.id}"> 
      <hr>
      
      <label for="username"><b>Book Name</b></label>
      <input type="text" placeholder="Enter Book Name" name="book_name" value="${book.name}" required>      
      
      <label for="email"><b>Book Description</b></label>
      <input type="text" placeholder="Enter Book Description" name="book_desccription" value="${book.description}" style="width: 100%;  padding: 12px 20px;  margin: 8px 0;  display: inline-block;  border: 1px solid #ccc;  box-sizing: border-box;" required>

      <label for="contact"><b>Book Author</b></label>
      <input type="text" placeholder="Enter Book Author" name="book_author" value="${book.author}" style="width: 100%;  padding: 12px 20px;  margin: 8px 0;  display: inline-block; border: 1px solid #ccc;  box-sizing: border-box;" required>

      <label for="psw"><b>Book Price</b></label>
      <input type="text" placeholder="Enter Book Price" id="password" name="book_price" value="${book.price}" required>
      
      <label for="psw"><b>Number of Stock</b></label>
      <input type="text" placeholder="Enter Number of Stock" id="password" name="book_stock" value="${book.stock}" required>
      
      <div class="clearfix">
        <button type="button" onclick="document.getElementById('editBookInfo').style.display='none'" class="cancelbtn2">Cancel</button>
        <button type="submit" class="signupbtn">Update</button>
      </div>
    </div>
  </form>
</div>


