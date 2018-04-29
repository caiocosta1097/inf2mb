package br.senai.sp.jandira.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.senai.sp.jandira.view.FrmClientes;

public class FrmClientes extends JFrame {
	
	private JPanel painelPrincipal;
	private JTable table;

	public FrmClientes() {
		setTitle("Dados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 356);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);

		JPanel painelSuperior = new JPanel();
		painelSuperior.setBackground(Color.BLUE);
		painelSuperior.setBounds(0, 0, 447, 67);
		painelPrincipal.add(painelSuperior);
		painelSuperior.setLayout(null);

		JLabel lblTitulo = new JLabel("Academia Boa Forma");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/senai/sp/jandira/forms/gym.png")));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 26));
		lblTitulo.setBounds(10, 11, 427, 45);
		painelSuperior.add(lblTitulo);
		
		JPanel painelInferior = new JPanel();
		painelInferior.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Clientes da Academia:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		painelInferior.setBounds(10, 78, 427, 178);
		painelPrincipal.add(painelInferior);
		painelInferior.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Arial", Font.BOLD, 12));
		scrollPane.setBounds(10, 22, 407, 145);
		painelInferior.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "NOME", "TELEFONE", "E-MAIL"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(0).setMinWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(140);
		table.getColumnModel().getColumn(1).setMinWidth(25);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		table.getColumnModel().getColumn(3).setPreferredWidth(160);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		
		JButton btnAdicionarCliente = new JButton("ADICIONAR CLIENTE");
		btnAdicionarCliente.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/senai/sp/jandira/forms/plus.png")));
		btnAdicionarCliente.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAdicionarCliente.setBounds(20, 267, 165, 39);
		painelPrincipal.add(btnAdicionarCliente);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/senai/sp/jandira/forms/icon.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 11));
		btnSair.setBounds(329, 267, 93, 39);
		painelPrincipal.add(btnSair);
		
		setVisible(true);
	}

}
