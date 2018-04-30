package br.senai.jandira.sp.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class FrmClientes extends JFrame {

	private JPanel painelTabela;

	public FrmClientes() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 375);
		painelTabela = new JPanel();
		painelTabela.setBackground(new Color(255, 255, 225));
		painelTabela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelTabela);
		painelTabela.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelTitulo.setBackground(new Color(255, 255, 255));
		painelTitulo.setBounds(0, 0, 744, 64);
		painelTabela.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Boa Forma");
		lblNewLabel.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/senai/jandira/sp/images/academia.png")));
		lblNewLabel.setForeground(new Color(37, 183, 211));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 32));
		lblNewLabel.setBounds(10, 0, 420, 64);
		painelTitulo.add(lblNewLabel);
		
		JPanel painelDados = new JPanel();
		painelDados.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Dados:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(37, 183, 211)));
		painelDados.setBackground(new Color(255, 255, 225));
		painelDados.setBounds(10, 75, 310, 260);
		painelTabela.add(painelDados);
		painelDados.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 27, 46, 14);
		painelDados.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 52, 46, 14);
		painelDados.add(lblCpf);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 77, 46, 14);
		painelDados.add(lblEmail);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(10, 102, 46, 14);
		painelDados.add(lblSexo);
		
		JLabel lblDtNasc = new JLabel("Data de nascimento:");
		lblDtNasc.setBounds(10, 127, 105, 14);
		painelDados.add(lblDtNasc);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(10, 152, 46, 14);
		painelDados.add(lblAltura);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(10, 177, 46, 14);
		painelDados.add(lblPeso);
		
		JPanel painelResultados = new JPanel();
		painelResultados.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Resultados:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(37, 183, 211)));
		painelResultados.setBackground(new Color(255, 255, 225));
		painelResultados.setBounds(330, 75, 404, 260);
		painelTabela.add(painelResultados);
		painelResultados.setLayout(null);
	}

}
