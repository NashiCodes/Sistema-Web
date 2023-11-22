package com.ldsw.dcc192.controllers;

import com.ldsw.dcc192.dao.DaoUsuario;
import com.ldsw.dcc192.Models.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "Controller", value = "/Controller")
public class Controller extends HttpServlet {
    private static final String logged = "logged";
    private transient HttpSession session = null;
    private String user;
    private String password;
    private String action;
    private String loggedIn;
    private transient HttpServletRequest request;
    private transient HttpServletResponse response;
    private transient RequestDispatcher rd = null;

    public void login(String user, String password) throws IOException {
        if (user == null || password == null) {
            this.session.setAttribute("error", "Os campos usuário e senha são obrigatórios");
            return;
        }
        Usuario temp = DaoUsuario.buscarPorMatricula(user);
        if (temp != null && temp.getSenha().equals(password)) {
            this.session.setAttribute(logged, "true");
            this.session.setAttribute("user", user);
            this.session.setAttribute("page", "menu");
            this.response.sendRedirect("menu.jsp");
            return;
        }
        this.session.setAttribute("error", "Usuário ou senha incorretos");
    }


    public void processAction() throws IOException {
        switch (this.action) {
            case "entrar":
                login(this.user, this.password);
                break;
            case "cadastro":
                this.rd = request.getRequestDispatcher("cadastro.jsp");
                break;
            case "cadastrar":
                if (loggedIn != null && loggedIn.equals("true")) {
                    //acao para cadastrar usuario
                    System.out.println("cadastrar usuario");
                } else {
                    this.rd = request.getRequestDispatcher("/Cadastrar");
                }
                break;
            case "logout":
                if (loggedIn != null && loggedIn.equals("true")) {
                    this.session.removeAttribute(logged);
                    this.session.removeAttribute("user");
                    this.rd = request.getRequestDispatcher("logout.jsp");
                } else
                    this.session.setAttribute("error", "Você precisa estar logado para acessar esta página");
                break;
            case "welcome":
                this.session.setAttribute("page", "welcome");
                this.response.sendRedirect("welcome.jsp");
                break;
            case "menu":
                this.session.setAttribute("page", "menu");
                this.response.sendRedirect("menu.jsp");
                break;
            case "counter":
                this.session.setAttribute("page", "counter");
                this.response.sendRedirect("counter.jsp");
                break;
            case "list":
                this.session.setAttribute("page", "list");
                this.response.sendRedirect("list.jsp");
                break;
            case "error":
                this.session.setAttribute("page", "error");
                this.response.sendRedirect("error.jsp");
                break;
            default:
                this.session.setAttribute("error", "Ação não reconhecida");
                String thisPage = (String) this.session.getAttribute("page") + ".jsp";
                this.rd = request.getRequestDispatcher(thisPage);
                break;
        }
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.session = request.getSession();
        this.loggedIn = (String) session.getAttribute(logged);
        this.action = request.getParameter("action");
        this.user = request.getParameter("username");
        this.password = request.getParameter("password");
        this.request = request;
        this.response = response;
        this.rd = null;
        if (action != null)
            processAction();

        if (this.rd != null)
            this.rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}