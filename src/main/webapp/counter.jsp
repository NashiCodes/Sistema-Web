<%--
  Created by IntelliJ IDEA.
  User: Nashi
  Date: 16/11/2023
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Counter</title>
    <meta charset="UTF-8">
    <jsp:include page="Components/bootstrap.html"/>
</head>
<body>
<jsp:include page="Components/navbar.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>Contador de Usuarios</h1>
            <p>Usuarios Logados: <%
                ServletContext context = request.getServletContext();
                out.println(context.getAttribute("userCount"));
            %></p>
            <form action="Controller" method="post">

            </form>
        </div>
    </div>
</div>
</body>
</html>
