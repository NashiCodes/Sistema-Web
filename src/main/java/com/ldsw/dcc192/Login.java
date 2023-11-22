package com.ldsw.dcc192;

import com.ldsw.dcc192.dao.DaoUsuario;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.Console;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
	private String _adminUser;
	private String _adminPassword;

	@Override
	public void init() {
		this._adminUser = getInitParameter("admin-user");
		this._adminPassword = getInitParameter("admin-password");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		request.getRequestDispatcher("index.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		var username = request.getParameter("username");
		var password = request.getParameter("password");
		var error404 = request.getParameterValues("erro404");

		//Gerar erro 404 se for passado o checkbox de erro 404
		if (error404 != null && error404.length > 0) {
			response.sendError(404);
			return;
		}

		if (username == null || password == null || username.isEmpty() || password.isEmpty())
			response.sendRedirect("");
		else if (username.equals(_adminUser) && password.equals(_adminPassword)) {
			loginAdm(request, response, username);
		} else {
			var Usuario = DaoUsuario.buscarPorMatricula(username);
			if (Usuario != null && Usuario.getSenha().equals(password))
				login(request, response, Usuario);
			return;
		}
		try {
			request.getSession(true).setAttribute("error", "Usuário ou senha inválidos");
			response.sendRedirect("");
		} catch (Exception e) {
			Console console = System.console();
			console.printf("Erro: %s", e.getMessage());
		}
	}

	private void loginAdm(HttpServletRequest request, HttpServletResponse response, String admin) throws IOException {
		try {
			request.getSession(true).setAttribute("logged", admin);
			response.sendRedirect("menu.jsp");
		} catch (Exception e) {
			request.getSession(true).setAttribute("error", "Erro: " + e.getMessage());
			response.sendRedirect("");
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response, com.ldsw.dcc192.Models.Usuario usuario) throws IOException {
		try {
			request.getSession(true).setAttribute("logged", usuario.getMatricula());
			response.sendRedirect("menu.jsp");
		} catch (Exception e) {
			request.getSession(true).setAttribute("error", "Erro: " + e.getMessage());
			response.sendRedirect("");
		}
	}

}