package com.ldsw.dcc192.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConFactory {
	public static final int MYSQL = 0;
	public static final int JavaDB = 1;

	public static Connection conexao(String Nome, String Senha, int Banco) throws ClassNotFoundException, SQLException {
		switch (Banco) {
			case MYSQL:
				Class.forName("com.mysql.cj.jdbc.Driver");
				return DriverManager.getConnection("jdbc:mysql://localhost:3306/dcc192?useSSL=false&serverTimezone=UTC", Nome, Senha);
			case JavaDB:

				Class.forName("org.apache.derby.jdbc.ClientDriver");
				return DriverManager.getConnection("jdbc:derby://localhost:1527/dcc192", Nome, Senha);
			default:
				return null;
		}
	}
}
