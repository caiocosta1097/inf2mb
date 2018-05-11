package br.senai.jandira.sp.app;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import br.senai.jandira.sp.dbUtils.Conexao;
import br.senai.jandira.sp.view.FrmAcademia;

public class BoaForma {

	public static void main(String[] args) {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    e.getMessage();
		}
		
		
		// Código para iniciar a aplicação
		FrmAcademia boaForma = new FrmAcademia();
		boaForma.setVisible(true);

	}

}
