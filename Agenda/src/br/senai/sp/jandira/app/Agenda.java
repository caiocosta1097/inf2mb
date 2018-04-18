package br.senai.sp.jandira.app;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.xml.crypto.Data;

import br.senai.sp.jandira.dbUtils.Conexao;
import br.senai.sp.jandira.view.FrmAgenda;

public class Agenda {

	public static void main(String[] args) {
		
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM contatos";
		
		
			try {
				stm = Conexao.abrirConexao().prepareStatement(sql);
				rs = stm.executeQuery();
				
				while (rs.next()){
					System.out.println("ID: " + rs.getString("id"));
					System.out.println("Nome: " + rs.getString("nome"));
					System.out.println("Data de nascimento: " + data.format(rs.getDate("dtNasc")));
					System.out.println("Endereço: " + rs.getString("endereco"));
					System.out.println("-------------------------------");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		FrmAgenda agenda = new FrmAgenda();
		agenda.setVisible(true);
		
	}

}
