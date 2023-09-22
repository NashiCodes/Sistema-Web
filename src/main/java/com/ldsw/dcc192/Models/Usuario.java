package com.ldsw.dcc192.Models;

import java.io.Serializable;

public class Usuario implements Serializable {
	private String matricula;

	private String senha;


	public Usuario(String matricula, String senha) {
		this.matricula = matricula;
		this.senha = senha;
	}

	public Usuario() {
	}
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
