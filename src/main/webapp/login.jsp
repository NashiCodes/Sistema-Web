<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div class="container">
    <h1>Login:</h1>
    <form action="Controller" method="post">
        <label for="username">Username:</label>
        <br>
        <input type="text" name="username" id="username" placeholder="Username" required>
        <br>
        <label for="password">Password:</label>
        <br>
        <input type="password" name="password" id="password" placeholder="Password" required>
        <br>
        <input type="submit" name="action" value="entrar">
        <input type="submit" name="action" value="cadastro">
    </form>
</div>
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
