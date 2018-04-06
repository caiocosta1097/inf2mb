package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class FrmAgenda extends JFrame {

	private JPanel painelPrincipal;
	private JTable tabelaContatos;
	JScrollPane scrollTabela;
	JPanel painelTabela;
	
	public FrmAgenda() {
		setTitle("Agenda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 430);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(Color.BLUE);
		painelTitulo.setBounds(0, 0, 534, 72);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblAgenda = new JLabel(" Agenda");
		lblAgenda.setForeground(Color.WHITE);
		lblAgenda.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/view/calendar (1).png")));
		lblAgenda.setBackground(Color.BLUE);
		lblAgenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgenda.setFont(new Font("Verdana", Font.BOLD, 26));
		lblAgenda.setBounds(10, 11, 514, 50);
		painelTitulo.add(lblAgenda);
		
		painelTabela = new JPanel();
		painelTabela.setBackground(SystemColor.control);
		painelTabela.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Contatos:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		painelTabela.setBounds(10, 83, 514, 260);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);
		
		
		
		/* tabelaContatos = new JTable();
		tabelaContatos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tabelaContatos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "NOME", "E-MAIL"
			}
		));
		tabelaContatos.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabelaContatos.getColumnModel().getColumn(1).setPreferredWidth(300);
		tabelaContatos.getColumnModel().getColumn(2).setPreferredWidth(325);
		scrollTabela.setViewportView(tabelaContatos); */
		
		JButton btnAdicionarContato = new JButton("Adicionar contato");
		btnAdicionarContato.setBounds(46, 354, 122, 26);
		painelPrincipal.add(btnAdicionarContato);
	}
	
	public void criarTabela(){
		
		scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 25, 494, 224);
		painelTabela.add(scrollTabela);
		
		DefaultTableModel modeloTabela = new DefaultTableModel();
		Object[] linhas = new Object[3];
		
		int i = 0;
		while (i <5){
			linhas[0] = "1";
			linhas[1] = "Maria";
			linhas[2] = "maria@uol.com.br";
			modeloTabela.addRow(linhas);
			i++;
		}
		
		String[] titulo = {"ID", "NOME", "E-MAIL"};
		modeloTabela.setColumnIdentifiers(titulo);
		
		tabelaContatos.setModel(modeloTabela);
		
		scrollTabela.setViewportView(tabelaContatos);
	}
}
