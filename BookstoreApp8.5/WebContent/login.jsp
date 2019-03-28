<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="WEB-INF/sampletags.tld" prefix="sampletag"%>
 <%@ page import="com.mapua.lab.model.Utils" %>
 <%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log-in</title>
<link href="style.css" type="text/css" rel="stylesheet" >
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<style>

.vertical-center {
  margin: 0;
  position: absolute;
  top: 50%;
  -ms-transform: translateY(-50%);
  transform: translateY(-50%);
}

.marquee{
	overflow-x: hidden;
}

</style>
</head>
<body>

<% 
	if (session.getAttribute(Utils.USER_SESSION) != null) { 
		response.sendRedirect("addBookForm.jsp"); 
	}
%>
<div class="topnav" >
			<!-- <img src="img/booklogo.png" style="float: left; width: 50px;"/> -->
			<button onclick="document.getElementById('id02').style.display='block'" style="width:auto;float: right;margin-right:10px">Sign-up</button>
			<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;float: right;margin-right:10px">Login</button> 
			<sampletag:greet color="blue"/>
</div><!--  
	
--><div class="marquee" style="font-size:0;" >
	<img src="https://i.imgur.com/aenbuST.jpg" height="520">
	<img src="https://i.imgur.com/aenbuST.jpg" height="520">
	<img src="https://i.imgur.com/aenbuST.jpg" height="520">
	<img src="https://i.imgur.com/aenbuST.jpg" height="520">
	<img src="https://i.imgur.com/aenbuST.jpg" height="520"><!-- https://i.imgur.com/aenbuST.jpg-->
</div>
	

<div class="row" style="height:auto;background-color: #808080" >
  	<div class="column" >
    	<h1>Company</h1>
    	<ul>
	      <li>About</li>
	      <li>Mission</li>
	      <li>Services</li>
	      <li>Social</li>
	      <li>Get in touch</li>
    	</ul>
  	</div>
  	<div class="column" >
    	<h1>Products</h1>
    	<ul>
	      <li>About</li>
	      <li>Mission</li>
	      <li>Services</li>
	      <li>Social</li>
	      <li>Get in touch</li>
    	</ul>
  	</div>

  	<div class="column" >
    	<h1>Support</h1>
    	<ul>
      		<li>Contact us</li>
   		   	<li>Web chat</li>
   	   		<li>Open ticket</li>
    	</ul>
  	</div>
  	
	<div class="column">
			<h1>Social Media</h1>
			<ul >
				<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"> Facebook</i></a></li>
				<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"> Twitter</i></a></li>
				<li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"> Google+</i></a></li>
				<li><a href="#"><i class="fa fa-linkedin" aria-hidden="true"> LinkedIn</i></a></li>
				<li><a href="#"><i class="fa fa-instagram" aria-hidden="true"> Instagram</i></a></li>
			</ul>
	</div>
</div>


	
	<div class="bottom-bar" style="height:8px;">
	      All Rights Reserved © 2016 | <a href="">Privacy Policy</a> | <a href="">Terms of Service</a>
	</div>



<%@include file="include/loginForm.jsp" %> <!-- Login modal Form -->
<%@include file="include/signupForm.jsp" %> <!-- Sign-up modal Form -->



</body>
</html>

<script>
// Get the modal
var modal = document.getElementById('id01');
var modal2 = document.getElementById('id02');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal || event.target == modal2) {
        modal.style.display = "none";
        modal2.style.display = "none";
    }
}
</script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"> 						////*! jQuery v1.7.2 jquery.com | jquery.org/license */
</script>				
<script src="https://cdnjs.cloudflare.com/ajax/libs/jQuery.Marquee/1.5.0/jquery.marquee.js">					
</script>
<script>
$('.marquee').marquee({
    //speed in milliseconds of the marquee
    duration: 100000,
    //gap in pixels between the tickers
    gap: 00,
    //time in milliseconds before the marquee will start animating
    delayBeforeStart: 0,
	startVisible: true,
    //'left' or 'right'
    direction: 'left',
    //true or false - should the marquee be duplicated to show an effect of continues flow
	duplicated: true,
	//pauseOnHover: true,
});
</script>