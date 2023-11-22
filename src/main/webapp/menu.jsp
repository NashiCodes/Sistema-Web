<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
    <jsp:include page="Components/bootstrap.html"/>
</head>
<body>
<jsp:include page="Components/navbar.jsp"/>
<form action="Controller" method="post">
    <button type="submit" class="btn btn-primary btn-rounded" name="action" value="counter">Contador de Usuario</button>
    <button type="submit" class="btn btn-primary btn-rounded" name="action" value="list">Listar Usuarios</button>
    <button type="submit" class="btn btn-primary btn-rounded" name="action" value="add">Adicionar Usuario</button>
    <button type="submit" class="btn btn-warning btn-rounded" name="action" value="erro">Warning</button>
    <input type="submit" name="action" value="logout" placeholder="Logout">
</form>
</body>
</html>
