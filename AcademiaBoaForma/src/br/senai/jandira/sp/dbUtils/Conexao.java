package br.senai.jandira.sp.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public static Connection con;
	
	// Método estático para abrir conexão com banco de  dados
	public static Connection abrirConexao() {
		con = null;

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 String dbURL = "jdbc:ucanaccess://C:/Users/17259196/Documents/GitInf2mb/inf2mb/academia.accdb";
//			String dbURL = "jdbc:ucanaccess://C:/Users/Caio/Documents/GItInf2mb/inf2mb/academia.accdb";
			con = DriverManager.getConnection(dbURL);
		} catch (Exception erro) {
			System.out.println("Erro");
			System.out.println(erro.getMessage());
		}

		return con;
	}
}
