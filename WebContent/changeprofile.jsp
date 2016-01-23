<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.billShare.DAO.*, com.billShare.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
String idS = request.getParameter("id");
%>
<title>Change Profile</title>
</head>
<body>
<form action="update" method=post>
	User name<br>
	<input type="text" name="uName" > <br>
	Password<br>
	<input type="password" name="psw" ><br>
	<input type="hidden" name="id" value="<%=idS%>">
	<input type="submit" >
</form>
</body>
</html>