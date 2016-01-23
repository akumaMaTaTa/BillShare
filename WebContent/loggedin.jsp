<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.billShare.DAO.*, com.billShare.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
userDAO d = new userDAO();
String userName = request.getParameter("uName");
String psw = request.getParameter("psw");
User user = d.authenticate(userName,psw);
if (user==null)
	%><h1>User not Found!</h1><%
else
{
%>
<h1><%=user.getUserName() %></h1>
<a href=personalpage.jsp?id=<%= user.getUserId()%>>Personal Page</a>
<%} %>
</body>
</html>