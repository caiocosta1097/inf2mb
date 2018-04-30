package br.senai.jandira.sp.app;

import br.senai.jandira.sp.dbUtils.Conexao;
import br.senai.jandira.sp.view.FrmAcademia;

public class BoaForma {

	public static void main(String[] args) {
		
		Conexao.abrirConexao();
		FrmAcademia frmAcademia = new FrmAcademia();
		frmAcademia.setVisible(true);

	}

}
