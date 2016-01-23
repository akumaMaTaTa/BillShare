<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.billShare.DAO.*, com.billShare.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign UP</title>
</head>
<body>
<h1> SIGN UP</h1>
<form action="registry" method=post>
	User name<br>
	<input type="text" name="uName" > <br>
	Email<br>
	<input  type="text" name="email"><br>
	Password<br>
	<input type="password" name="psw" ><br>
	<input type="submit" >

</form>
<input name="status" type="hidden" value="enter" > 
<h1>SIGN IN</h1>
<form action="login" method=post>
<%
String status = request.getParameter("status");
if("re-enter".equals(status))
{%>
	<h3>Incorrect username or password </h3>
<%} %>
	User name<br>
	<input type="text" name="uName" > <br>
	Password<br>
	<input type="password" name="psw" ><br>
	<input type="submit" >
</form>

	
</body>
</html>
