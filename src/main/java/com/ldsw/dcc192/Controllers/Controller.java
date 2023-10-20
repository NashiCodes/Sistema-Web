package com.ldsw.dcc192.Controllers;

import com.ldsw.dcc192.DAO.DaoUsuario;
import com.ldsw.dcc192.Models.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Controller", value = "/Controller")
public class Controller extends HttpServlet {

    public boolean login(String _user, String _password) {
        Usuario temp = DaoUsuario.buscarPorMatricula(_user);
        return temp != null && temp.getSenha().equals(_password);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var session = request.getSession(true);
        String loggedIn;
        RequestDispatcher rd;
        String action = request.getParameter("action");
        String user = request.getParameter("username");
        String password = request.getParameter("password");
        if (action != null) {
            switch (action) {
                case "entrar":
                    if (login(user, password)) {
                        session.setAttribute("logged", "true");
                        session.setAttribute("user", user);
                        rd = request.getRequestDispatcher("welcome.jsp");
                        rd.forward(request, response);
                    } else {
                        session.setAttribute("logged", "false");
                        rd = request.getRequestDispatcher("login.jsp");
                        rd.forward(request, response);
                    }
                    break;
                case "login":
                    rd = request.getRequestDispatcher("login.jsp");
                    rd.forward(request, response);
                    break;
                case "cadastro":
                    rd = request.getRequestDispatcher("cadastro.jsp");
                    rd.forward(request, response);
                    break;
                case "cadastrar":
                    loggedIn = (String) session.getAttribute("logged");
                    if (loggedIn != null && loggedIn.equals("true")) {
                        //acao para cadastrar usuario
                        System.out.println("cadastrar");
                    } else {
                        session.setAttribute("error", "Você precisa estar logado para acessar esta página");
                        rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                    }
                    break;
                case "logout":
                    loggedIn = (String) session.getAttribute("logged");
                    if (loggedIn != null && loggedIn.equals("true")) {
                        session.setAttribute("logged", "false");
                        session.setAttribute("user", null);
                        rd = request.getRequestDispatcher("logout.jsp");
                        rd.forward(request, response);
                    } else {
                        session.setAttribute("error", "Você precisa estar logado para acessar esta página");
                        rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                    }
                    break;
                case "welcome":
                    rd = request.getRequestDispatcher("welcome.jsp");
                    rd.forward(request, response);
                    break;
                default:
                    session.setAttribute("error", "Ação não reconhecida");
                    rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                    break;
            }
        } else {
            session.setAttribute("logged", "false");
            rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);

        }
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