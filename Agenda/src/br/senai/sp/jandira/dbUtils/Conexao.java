package br.senai.sp.jandira.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	public static Connection con;
	
	public static Connection abrirConexao (){
		con = null;
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String dbURL = "jdbc:ucanaccess://C:/Users/17259196/Documents/GitInf2mb/inf2mb/agenda.accdb";
			con = DriverManager.getConnection(dbURL);
		}
		catch(Exception erro){
			System.out.println("Erro");
			System.out.println(erro.getMessage());
		}
		
		return con;
	}
}
