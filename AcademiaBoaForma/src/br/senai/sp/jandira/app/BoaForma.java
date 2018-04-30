package br.senai.sp.jandira.app;

import br.senai.sp.jandira.dbUtils.Conexao;
import br.senai.sp.jandira.view.FrmAcademia;
import br.senai.sp.jandira.view.FrmClientes;

public class BoaForma {

	public static void main(String[] args) {
		
		Conexao.abrirConexao();
		FrmAcademia frmAcademia = new FrmAcademia();
		//FrmClientes frmClientes = new FrmClientes();
		frmAcademia.setVisible(true);

	}

}
