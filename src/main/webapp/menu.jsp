<%@ page import="java.util.Timer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<%
	String username = (String) session.getAttribute("logged");
	
	if (username == null || username.isEmpty()) {
		response.sendRedirect("index.jsp");
	} else {
%>
		<h1>Logged as <%= username %></h1>
		<a href="index.jsp">Logout</a>
<%
	}
%>
</body>
</html>
