package br.senai.sp.jandira.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	public static Connection con;
	
	// Método para abrir conexão com banco de dados
	
	public static Connection abrirConexao (){
		con = null;
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String dbURL = "jdbc:ucanaccess://C:/Users/Guilherme/Documents/GitInf2mb/inf2mb/boaForma.accdb";
			con = DriverManager.getConnection(dbURL);
			System.out.println("Banco de Dados conectado com sucesso...");
		}
		catch(Exception erro){
			System.out.println("Erro");
			System.out.println(erro.getMessage());
		}
		
		return con;
	}
}
