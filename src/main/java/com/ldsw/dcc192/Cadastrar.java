package com.ldsw.dcc192;

import com.ldsw.dcc192.dao.DaoUsuario;
import com.ldsw.dcc192.Models.Usuario;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Cadastrar", value = "/Cadastrar")
public class Cadastrar extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		var matricula = request.getParameter("user");
		var senha = request.getParameter("password");
		var confirm = request.getParameter("confirm");

		if (isStringValid(matricula) && isStringValid(senha) && isStringValid(confirm)) {
			if (senha.equals(confirm)) {
				try {
					DaoUsuario.inserir(new Usuario(matricula, senha));
					request.getSession(true).setAttribute("user", matricula);
					request.getSession(true).setAttribute("logged", "true");
					response.sendRedirect("welcome.jsp");
				} catch (Exception e) {
					request.getSession(true).setAttribute("error", "Erro: " + e.getMessage());
					response.sendRedirect("cadastro.jsp");
				}
			} else {
				request.getSession(true).setAttribute("error", "As senhas não coincidem");
				response.sendRedirect("cadastro.jsp");
			}
		} else {
			request.getSession(true).setAttribute("error", "Preencha todos os campos");
			response.sendRedirect("cadastro.jsp");
		}
	}

	private boolean isStringValid(String string) {
		return string != null && !string.isEmpty();
	}
}