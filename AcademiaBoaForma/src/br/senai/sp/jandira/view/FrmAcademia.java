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

import br.senai.sp.jandira.dao.ClienteDAO;
import br.senai.sp.jandira.model.Cliente;
import br.senai.sp.jandira.view.FrmAcademia;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class FrmAcademia extends JFrame {

	private JPanel painelPrincipal;
	private JTable tabelaClientes;
	private JPanel painelTabela;
	private JScrollPane scrollTabela;

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

		painelTabela = new JPanel();
		painelTabela.setBackground(new Color(255, 255, 225));
		painelTabela.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Clientes da Academia:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(66, 149, 206)));
		painelTabela.setBounds(10, 78, 437, 178);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);

		scrollTabela = new JScrollPane();
		scrollTabela.setFont(new Font("Arial", Font.BOLD, 12));
		scrollTabela.setBounds(10, 22, 417, 145);
		painelTabela.add(scrollTabela);
		
		montarTabela();

		JButton btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// // Data inicial
				// Calendar dataInicio = Calendar.getInstance();
				// // Atribui a data de 10/FEV/2008
				// dataInicio.set(1997, Calendar.FEBRUARY, 10);
				// // Data de hoje
				// Calendar dataFinal = Calendar.getInstance();
				// // Calcula a diferença entre hoje e da data de inicio
				// Long diferenca = dataFinal.getTimeInMillis() -
				// dataInicio.getTimeInMillis();
				// // Quantidade de milissegundos em um dia
				// int tempoDia = 1000 * 60 * 60 * 24;
				// Long diasDiferenca = diferenca / tempoDia;
				// int idade = Integer.valueOf(diasDiferenca.toString());
				// int anos = idade/365;
				// System.out.println("Entre a data inicial e final são " +
				// anos + " dias de diferença.");
			}
		});
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

	}
	
	public void montarTabela(){
		scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 22, 417, 145);
		painelTabela.add(scrollTabela);
		
		tabelaClientes = new JTable();
		
		DefaultTableModel modeloTabela = new DefaultTableModel();
		String[] nomesColunas = {"CPF", "NOME", "SEXO"};
		modeloTabela.setColumnIdentifiers(nomesColunas);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		clientes = clienteDAO.getContatos();
		
		Object[] linha = new Object[3];
		
		for(Cliente cliente : clientes){
			linha[0] = cliente.getCpf();
			linha[1] = cliente.getNome();
			linha[2] = cliente.getSexo();
			modeloTabela.addRow(linha);
		}
		
		tabelaClientes.setModel(modeloTabela);
		tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(25);
		tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(220);
		scrollTabela.setViewportView(tabelaClientes);
	}
}
