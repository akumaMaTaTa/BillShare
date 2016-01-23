<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.billShare.DAO.*, com.billShare.entity.*,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
</head>
<body>
<input name="action" type="hidden" value="noAction"/>
<%
userDAO d = new userDAO();
List<User> users = d.readAll();
String action = request.getParameter("action");
String id = request.getParameter("id");
if("delete".equals(action))
{
	Long userid = (long)0;
	d.deleteUser(userid.parseLong(id));
	response.sendRedirect("admin.jsp");
}
for (User user: users)
{%>
	<li>
		<%=user.getUserId() %>
		<a href="personalpage.jsp?id=<%=user.getUserId()%>"><%=user.getUserName() %></a>
		<a href="admin.jsp?id=<%=user.getUserId()%>&action=delete">&times;</a>
	</li>
<%}
%>
</body>
</html>