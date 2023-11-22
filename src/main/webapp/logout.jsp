<%--
  Created by IntelliJ IDEA.
  User: Nashi
  Date: 12/09/2023
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>LDSW</title>
</head>
<body>
<%
	session.invalidate();
	response.sendRedirect("index.jsp");
%>
</body>
</html>
