package br.senai.jandira.sp.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
public static Connection con;
	
	public static Connection abrirConexao (){
		con = null;
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String dbURL = "jdbc:ucanaccess://C:/Users/caioc/OneDrive/Documentos/SENAI/Repositorio/inf2mb/academia.accdb";
			con = DriverManager.getConnection(dbURL);
			System.out.println("Banco conectado com sucesso...");
		}
		catch(Exception erro){
			System.out.println("Erro");
			System.out.println(erro.getMessage());
		}
		
		return con;
	}
}
