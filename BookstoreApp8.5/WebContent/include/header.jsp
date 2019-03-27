<%@ taglib uri="/WEB-INF/sampletags.tld" prefix="sampletag"%>
<%@ page import="com.mapua.lab.model.Utils" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- validate if there is a user session and validate if that user is an admin -->
<c:if test = '${sessionScope[Utils.USER_SESSION] == null}'>
        <c:redirect url = "login.jsp"/>
</c:if>
<%-- <% 
	if (session.getAttribute(Utils.USER_SESSION) == null) { 
		response.sendRedirect("login.jsp"); 
	}
%>
 --%>
<table>
	<tr>
		<td><img src="img/booklogo.png"/></td>
<!-- 	</tr> -->
<%-- 	<tr>
		<td>Short Date <sampletag:date style="short"/></td> 
	</tr>
	<tr>
		<td>Medium Date <sampletag:date style="medium"/></td>
	</tr> --%>
<!-- 	<tr> -->
		<td> Date: <sampletag:date style="long"/></td>
<!-- 	</tr>
	<tr> -->
		<td> Welcome <b><c:out value="${sessionScope[Utils.USER_SESSION]}"/><%-- <%=(String) session.getAttribute(Utils.USER_SESSION)%> --%></b></td>
	</tr>
	<tr>
	
	<c:if test = '${sessionScope[Utils.USER_SESSION] != null}'>
        <button type="submit" form="logout_btn" style="width:auto;float: right;margin-right:10px">Logout</button>
		<form action="LogoutServlet" method="post" id="logout_btn">
		</form>
    </c:if>
	
	</tr>
</table>

	
