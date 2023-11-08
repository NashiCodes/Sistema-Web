<%@ page import="com.ldsw.dcc192.Controllers.Listener" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Welcome <%request.getAttribute("user"); %></h1>
<div>
    <h2> Este é o Menu do Sistema</h2>
    <p>Escolha a sua ação:</p>
    <form action="Controller" method="post">
        <input type="submit" name="action" value="menu" placeholder="Menu">
        <input type="submit" name="action" value="logout" placeholder="Sair">
    </form>
</div>
<div>
    <h2>Quantidades de Usuarios: </h2>
    <p><%
        ServletContext context = request.getServletContext();
        out.println(context.getAttribute("userCount"));
    %></p>
</div>
</body>
</html>
