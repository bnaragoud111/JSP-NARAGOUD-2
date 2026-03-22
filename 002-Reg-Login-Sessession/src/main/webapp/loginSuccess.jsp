<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
String user = (String) session.getAttribute("user");
//Get current time
java.util.Date loginTime = new java.util.Date();
if (user == null) {
	response.sendRedirect("login.jsp");
}
%>

<html>
<head>
<title>Success</title>
</head>

<body
	style="background-color: green; color: white; text-align: center; margin-top: 100px;">
	<h4 style="text-align: right; color:red; margin-left: 10px;">logged in at <%=loginTime%> </h4>
	
	<h3 style="text-align: left; margin-left: 20px;">Hello...<%=user%></h3>

	<h3>You have logged in Successful ✅</h3>


	<h4>Check Bank Statement</h4>
	<h4>Request Cheque Book</h4>
	<h4>Apply Loan</h4>
	<!--	<h2><a href="logout.jsp" style="text-align: right; color:red; margin-left: 20px;">logout </a></h2> -->
		<h2><a href="logout" style="text-align: right; color:red; margin-left: 20px;">logout </a></h2> 
	

</body>
</html>