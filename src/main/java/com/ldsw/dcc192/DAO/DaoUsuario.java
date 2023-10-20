package com.ldsw.dcc192.DAO;

import com.ldsw.dcc192.Models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;


public class DaoUsuario {
	private static final int BANCO = 0;
	private static final String NOME = "root";
	private static final String SENHA = "root";

	private static Connection con;
	private static PreparedStatement comando;

	//	public DaoUsuario(int _BANCO, String _NOME, String _SENHA) {
	//		BANCO = _BANCO;
	//		NOME = _NOME;
	//		SENHA = _SENHA;
	//	}

	public static void inserir(Usuario usuario) throws SQLException {
		conectar();
		try {
			var query = "INSERT INTO usuario (matricula, senha) VALUES (?, ?)";
			comando = con.prepareStatement(query);
			comando.setString(1, usuario.getMatricula());
			comando.setString(2, usuario.getSenha());
			comando.executeUpdate();
		} catch (SQLException e) {
			imprimeErro("Erro ao inserir usuario", e.getMessage());
			throw e;
		} finally {
			fechar();
		}
	}

	public static void apagar(String Id) {
		conectar();
		try {
			comando.execute("DELETE FROM usuario WHERE matricula = ? ", new String[]{Id});
		} catch (SQLException e) {
			imprimeErro("Erro ao apagar usuario", e.getMessage());
		} finally {
			fechar();
		}
	}

	public static List<Usuario> buscarTodos() {
		conectar();
		var usuarios = new ArrayList<Usuario>();
		try {
			var resultado = comando.executeQuery("SELECT * FROM usuario");
			while (resultado.next()) {
				var user = new Usuario(resultado.getString("matricula"),
						resultado.getString("senha"));
				usuarios.add(user);
			}
		} catch (SQLException e) {
			imprimeErro("Erro ao buscar usuarios", e.getMessage());
		} finally {
			fechar();
		}
		return usuarios;
	}

	public static Usuario buscarPorMatricula(String matricula) {
		conectar();
		Usuario usuario = null;
		try {
			var query = "SELECT * FROM usuario WHERE matricula = ?";
			comando = con.prepareStatement(query);
			comando.setString(1, matricula);
			var resultado = comando.executeQuery();
			if (resultado.next()) {
				usuario = new Usuario(resultado.getString("matricula"),
						resultado.getString("senha"));
			}
		} catch (SQLException e) {
			imprimeErro("Erro ao buscar usuario", e.getMessage());
		} finally {
			fechar();
		}
		return usuario;
	}

	public static void atualizar(Usuario usuario) {
		conectar();
		try {
			var query = "UPDATE usuario SET senha = ? WHERE matricula = ?";
			comando = con.prepareStatement(query);
			comando.setString(1, usuario.getSenha());
			comando.setString(2, usuario.getMatricula());
			comando.executeUpdate();
		} catch (SQLException e) {
			imprimeErro("Erro ao atualizar usuario", e.getMessage());
		} finally {
			fechar();
		}
	}

	private static void conectar() {
		try {
			con = ConFactory.conexao(NOME, SENHA, BANCO);
		} catch (SQLException e) {
			imprimeErro("Erro ao conectar", e.getMessage());
		} catch (ClassNotFoundException e) {
			imprimeErro("Erro ao carregar o driver", e.getMessage());
		}
	}

	private static void fechar() {
		try {
			comando.close();
			con.close();
		} catch (SQLException e) {
			imprimeErro("Erro ao fechar conexão", e.getMessage());
		}
	}

	private static void imprimeErro(String msg, String msgErro) {
		//JOptionPane.showMessageDialog(null, msg, "Erro crítico", 0);
		System.err.println(msg);
		System.out.println(msgErro);
		System.exit(0);
	}
}
