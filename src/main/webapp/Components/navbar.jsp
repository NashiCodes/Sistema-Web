<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" %>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <!-- Container wrapper -->
    <div class="container-fluid">

        <!-- Collapsible wrapper -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent ">
            <!-- Navbar brand -->
            <a class="navbar-brand mt-2 mt-lg-0 ps-4">
                <img
                        src="https://upload.wikimedia.org/wikipedia/commons/e/e0/Bras%C3%A3o_da_UFJF.png"
                        style="height: 24px!important; width: auto!important"
                        alt="Logo UFJF"
                        loading="lazy"
                />
            </a>
            <!-- Left Welcome -->
            <div class="navbar-nav me-auto mb-2 mb-lg-0">
                <span class="navbar-text">
                    <%
                        String thisPage = (String) request.getSession().getAttribute("thisPage");
                        if (thisPage != null && thisPage.equals("welcome"))
                            out.print("Bem vindo, " + request.getSession().getAttribute("name"));
                        else
                            out.print("DCC-192 - Sistema Web");
                    %>
                </span>
            </div>
            <!-- Left Welcome -->
        </div>
        <!-- Collapsible wrapper -->
            <%
            String error = (String) request.getSession().getAttribute("error");
            if (error != null) {
%>
        <!-- Center warning -->
        <div class="d-flex align-items-center">
            <i class="fas fa-exclamation-triangle text-danger me-3"></i>
            <p class="mb-0">
                <span>Atenção:</span>
                <span>
                    <%= error %>
                </span>
            </p>
            <!-- Center warning -->
        </div>
            <% }
            request.getSession().removeAttribute("error");
            %>
        <!-- Container wrapper -->
</nav>
<!-- Navbar -->