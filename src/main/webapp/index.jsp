<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <jsp:include page="Components/bootstrap.html"/>
    <link rel="stylesheet" href="login.css">
</head>
<body>
<section class="vh-100">
    <div class="container-fluid h-custom">
        <jsp:include page="Components/navbar.jsp"/>
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-9 col-lg-6 col-xl-5">
                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                     class="img-fluid" alt="Sample image">
            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                <form action="Controller" method="post" id="login">
                    <!-- Email input -->
                    <div class="form-outline mb-4">
                        <label class="form-label" for="Username">Usuário</label>
                        <input type="text" id="Username" class="form-control form-control-lg" name="username"
                               placeholder="Digite seu usuário"/>
                    </div>

                    <!-- Password input -->
                    <div class="form-outline mb-3">
                        <label class="form-label" for="Senha">Senha</label>
                        <input type="password" id="Senha" class="form-control form-control-lg" name="password"
                               placeholder="Digite sua senha"/>
                    </div>

                    <div class="text-center text-lg-start mt-4 pt-2">
                        <button type="submit" class="btn btn-primary btn-lg"
                                style="padding-left: 2.5rem; padding-right: 2.5rem;"
                                name="action"
                                value="entrar"
                                id="submitLogin">Login
                        </button>
                        <button type="submit" class="btn btn-secondary btn-lg"
                                style="padding-left: 2.5rem; padding-right: 2.5rem;"
                                name="action"
                                value="cadastro">Cadastrar
                        </button>
                    </div>

                </form>
            </div>
        </div>
    </div>
    <div
            class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
        <!-- Copyright -->
        <div class="text-white mb-3 mb-md-0">
            Copyright © 2023. All rights reserved.
        </div>
        <!-- Copyright -->
    </div>
</section>
<script>
    let form = document.getElementById("login");
    form.addEventListener("change", function () {
        let username = document.getElementById("Username").value;
        let password = document.getElementById("Senha").value;
        let submit = document.getElementById("submitLogin");
        if (username.length > 0 && password.length > 0) {
            submit.removeAttribute("disabled");
        }
    });
</script>
</body>
</html>
