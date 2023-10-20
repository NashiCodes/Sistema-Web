<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <title>LDSW</title>
</head>
<body>
<h1>Bem-vindo</h1>
<p>O que deseja fazer?</p>
<form action="Controller" method="post">
    <input type="submit" name="action" value="cadastro" placeholder="Cadastrar-se">
    <input type="submit" name="action" value="login" placeholder="Login">
</form>
<%
    String error = (String) request.getSession().getAttribute("error");
    if (error != null) {%>
<div class="error">
    <%
            out.println(error);
            request.getSession().removeAttribute("error");
        }
    %>
</div>
</body>
</html>