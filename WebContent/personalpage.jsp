<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.billShare.DAO.*, com.billShare.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
String idS = request.getParameter("id");
Long id = (long)0;
userDAO d = new userDAO();
User user = d.readOne(id.parseLong(idS));
%>
<title><%=user.getUserName() %>'s page </title>
</head>
<body>
<h1><%=user.getUserName() %></h1>
<h3>USER ID : <%=user.getUserId() %></h3>
<h3>EMAIL : <%=user.getEmail() %></h3>
<h4>PASSWORD:<%=user.getPassword() %></h4>
<a href="changeprofile.jsp?id=<%=user.getUserId()%>">Change my profile</a>
<a href="creategroup.jsp">Create a new group</a>


</body>
</html>