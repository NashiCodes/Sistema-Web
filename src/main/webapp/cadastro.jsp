<%--
  Created by IntelliJ IDEA.
  User: Nashi
  Date: 21/09/2023
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro</title>
</head>
<body>
<div class="container">
    <h1>Cadastre-se:</h1>
    <form action="Cadastrar" method="post">
        <label for="registration">registration:</label>
        <br>
        <input type="text" name="registration" id="registration" placeholder="Registration" required>
        <br>
        <label for="password">Password:</label>
        <br>
        <input type="password" name="password" id="password" placeholder="Password" required>
        <br>
        <label for="confirm">Type your password again:</label>
        <br>
        <input type="password" name="confirm" id="confirm" placeholder="Confirm your password" required>
        <br>
        <br>
        <input type="submit" name="action" value="cadastrar" placeholder="Cadastrar">
    </form>
</div>
<% String error = (String) request.getSession().getAttribute("error");
    if (error != null) {%>
<div class="error">
    <% out.println(error);
        request.removeAttribute("error");
    } %>
</div>
</body>
</html>
