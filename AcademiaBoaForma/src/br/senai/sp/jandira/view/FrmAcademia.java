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

import br.senai.sp.jandira.view.FrmAcademia;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.border.EtchedBorder;

public class FrmAcademia extends JFrame {

	private JPanel painelPrincipal;
	private JTable table;

	public FrmAcademia() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(FrmAcademia.class.getResource("/br/senai/sp/jandira/images/academia.png")));
		setResizable(false);
		setTitle("Dados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 356);
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(255, 255, 225));
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);

		JPanel painelTitulo = new JPanel();
		painelTitulo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelTitulo.setBackground(new Color(255, 255, 255));
		painelTitulo.setBounds(0, 0, 457, 67);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);

		JLabel lblTitulo = new JLabel(" Academia Boa Forma");
		lblTitulo.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/images/academia.png")));
		lblTitulo.setBackground(Color.WHITE);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(66, 149, 206));
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		lblTitulo.setBounds(10, 0, 437, 56);
		painelTitulo.add(lblTitulo);

		JPanel painelTabela = new JPanel();
		painelTabela.setBackground(new Color(255, 255, 225));
		painelTabela.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true),
				"Clientes da Academia:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(66, 149, 206)));
		painelTabela.setBounds(10, 78, 437, 178);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Arial", Font.BOLD, 12));
		scrollPane.setBounds(10, 22, 417, 145);
		painelTabela.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null }, },
				new String[] { "ID", "NOME", "TELEFONE", "E-MAIL" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(0).setMinWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(140);
		table.getColumnModel().getColumn(1).setMinWidth(25);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		table.getColumnModel().getColumn(3).setPreferredWidth(160);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(table);

		JButton btnAdicionar = new JButton("");
		btnAdicionar.setBackground(new Color(255, 255, 255));
		btnAdicionar.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/images/adicionar.png")));
		btnAdicionar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAdicionar.setBounds(20, 267, 62, 52);
		painelPrincipal.add(btnAdicionar);

		JButton btnSair = new JButton("");
		btnSair.setBackground(new Color(255, 255, 255));
		btnSair.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/images/sair.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 11));
		btnSair.setBounds(385, 267, 62, 52);
		painelPrincipal.add(btnSair);

		JButton btnEditar = new JButton("");
		btnEditar.setBackground(new Color(255, 255, 255));
		btnEditar.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/images/editar.png")));
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnEditar.setBounds(92, 267, 62, 52);
		painelPrincipal.add(btnEditar);

		JButton btnExcluir = new JButton("");
		btnExcluir.setBackground(new Color(255, 255, 255));
		btnExcluir.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/images/deletar.png")));
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 11));
		btnExcluir.setBounds(164, 267, 62, 52);
		painelPrincipal.add(btnExcluir);

		setVisible(true);
	}
}
