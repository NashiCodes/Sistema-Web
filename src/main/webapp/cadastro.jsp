<%--
  Created by IntelliJ IDEA.
  User: Nashi
  Date: 21/09/2023
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cadastro</title>
    <jsp:include page="Components/bootstrap.html"/>
</head>
<body>
<section class="vh-100" style="background-color: #eee;">
    <jsp:include page="Components/navbar.jsp"/>
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Cadastre-se</p>

                                <form class="mx-1 mx-md-4" action="Controller" method="post" id="cadastro">

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <label class="form-label" for="user">Usuario</label>
                                            <input type="text" id="user" class="form-control" name="user"
                                                   placeholder="Seu usuario"/>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <label class="form-label" for="password">Senha</label>
                                            <input type="password" id="password" class="form-control" name="password"
                                                   placeholder="Digite sua senha"
                                            />
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <label class="form-label" for="confirm">Confirme sua senha</label>
                                            <input type="password" id="confirm" class="form-control" name="confirm"
                                                   placeholder="Confirme sua senha"/>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button type="submit" class="btn btn-primary btn-lg pointer-event"
                                                id="cadastroBtn"
                                                name="action" value="cadastrar"
                                                disabled>
                                            Cadastrar
                                        </button>
                                    </div>

                                </form>

                            </div>
                            <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                                     class="img-fluid" alt="Sample image">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script>
    let form = document.getElementById("cadastro");
    form.addEventListener("change", function () {
        let username = document.getElementById("user").value;
        let password = document.getElementById("password").value;
        let confirm = document.getElementById("confirm").value;
        let submit = document.getElementById("cadastroBtn");
        if (username.length > 0 && password.length > 0 && confirm.length > 0 && password === confirm) {
            submit.removeAttribute("disabled");
        }
    });
</script>
</body>
</html>
