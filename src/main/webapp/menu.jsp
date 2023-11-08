<%@ page import="java.util.Timer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Title</title>
</head>
<body>
<h1>Logged as <%= request.getSession().getAttribute("user") %>
</h1>
<form action="Controller" method="post">
    <input type="submit" name="action" value="welcome" placeholder="Voltar">
    <input type="submit" name="action" value="cadastrar" placeholder="Cadastrar Novo Usuario">
    <input type="submit" name="action" value="logout" placeholder="Logout">
</form>
</body>
</html>
