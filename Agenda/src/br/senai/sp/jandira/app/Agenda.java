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
		
		FrmAgenda agenda = new FrmAgenda();
		agenda.setVisible(true);
		
	}

}
