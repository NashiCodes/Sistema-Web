<%@ page import="com.ldsw.dcc192.Models.Usuario" %>
<%@ page import="com.ldsw.dcc192.dao.DaoUsuario" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista de usuários</title>
    <jsp:include page="Components/bootstrap.html"/>
</head>
<body>
<jsp:include page="Components/navbar.jsp"/>
<jsp:include page="Components/voltar.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>Lista de usuários</h1>
            <table class="table table-header table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Usuário</th>
                </tr>
                </thead>
                <tbody>
                <%
                    Map<Integer, Usuario> users = DaoUsuario.buscarTodos();
                    for (Map.Entry<Integer, Usuario> entry : users.entrySet()) {
                        int key = entry.getKey();
                        Usuario user = entry.getValue();
                %>
                <tr>
                    <td><%= key %>
                    </td>
                    <td><%= user.getMatricula() %>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
