<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt">
<head>
	<title>LDSW</title>
</head>
<body>
<div class="container">
	<h1>Login:</h1>
	<form action="Login" method="post">
		<label for="username">Username:</label>
		<br>
		<input type="text" name="username" id="username" placeholder="Username" required>
		<br>
		<label for="password">Password:</label>
		<br>
		<input type="password" name="password" id="password" placeholder="Password" required>
		<br>
		<label for="error404">Setar erro 404:</label>
		<br>
		<input type="checkbox" name="erro404" id="error404">
		<br>
		<input type="submit" value="Login">
		<input type="button" value="Cadastrar" onclick="window.location = 'cadastro.jsp'">
	</form>
</div>
<%
	String error = (String) request.getSession().getAttribute("error");
	if (error != null) {%>
<div class="error">
	<%
			out.println(error);
			request.removeAttribute("error");
		}
	%>
</div>
</body>
</html>