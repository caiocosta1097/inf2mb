package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class FrmAgenda extends JFrame {

	private JPanel painelPrincipal;

	public FrmAgenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 370);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(Color.LIGHT_GRAY);
		painelTitulo.setBounds(0, 0, 458, 62);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Agenda");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/view/calendar (1).png")));
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 32));
		lblTitulo.setBounds(10, 11, 438, 40);
		painelTitulo.add(lblTitulo);
		
		JPanel painelTabela = new JPanel();
		painelTabela.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Contatos:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		painelTabela.setBounds(10, 73, 438, 190);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);
	}
}
