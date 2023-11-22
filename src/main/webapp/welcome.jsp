<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <jsp:include page="Components/bootstrap.html"/>
</head>
<body>
<h1>Welcome <%out.println("çççççççççççç"); %></h1>
<div>
    <h2> Este é o Menu do Sistema</h2>
    <p>Escolha a sua ação:</p>
    <form action="Controller" method="post">
        <input type="submit" name="action" value="menu" placeholder="Menu">
        <input type="submit" name="action" value="logout" placeholder="Sair">
    </form>
</div>
</body>
</html>
