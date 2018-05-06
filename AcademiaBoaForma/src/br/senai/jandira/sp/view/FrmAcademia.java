package br.senai.jandira.sp.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.senai.jandira.sp.dao.ClienteDAO;
import br.senai.jandira.sp.model.Cliente;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.awt.event.ActionEvent;

public class FrmAcademia extends JFrame {

	private JPanel painelPrincipal;
	private JTable tabelaClientes;
	private JScrollPane scrollTabela;
	private JPanel painelTabela;
	
	// Método construtor de 'FrmAcademia'
	public FrmAcademia() {
		setResizable(false);
		setTitle("Boa Forma");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(FrmAcademia.class.getResource("/br/senai/jandira/sp/images/academia.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 335);
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(255, 255, 225));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);

		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(new Color(255, 255, 255));
		painelTitulo.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		painelTitulo.setBounds(0, 0, 494, 64);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);

		JLabel lblTitulo = new JLabel(" Boa Forma");
		lblTitulo.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/jandira/sp/images/academia.png")));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(37, 183, 211));
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 32));
		lblTitulo.setBounds(10, 0, 389, 64);
		painelTitulo.add(lblTitulo);

		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

		// Inserindo a data de hoje no 'lblData'
		JLabel lblData = new JLabel("");
		lblData.setBounds(409, 11, 75, 14);
		Date dataAtual = new Date();
		lblData.setText(data.format(dataAtual));
		painelTitulo.add(lblData);

		painelTabela = new JPanel();
		painelTabela.setBorder(new TitledBorder(new LineBorder(null), "Clientes:", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(37, 183, 211)));
		painelTabela.setBackground(new Color(255, 255, 225));
		painelTabela.setBounds(10, 75, 475, 145);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);
		
		// Chamando o 'criarTabela()'
		criarTabela();

		JPanel painelBotoes = new JPanel();
		painelBotoes.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		painelBotoes.setBackground(new Color(255, 255, 225));
		painelBotoes.setBounds(0, 231, 494, 75);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);
		
		JButton btnAdicionar = new JButton("");
		
		// Evento do 'btnAdicionar' para abrir o 'FrmClientes'
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmClientes frmClientes = new FrmClientes("NOVO");
				frmClientes.setVisible(true);
			}
		});
		btnAdicionar.setBackground(new Color(255, 255, 255));
		btnAdicionar.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/jandira/sp/images/adicionar.png")));
		btnAdicionar.setBounds(10, 11, 65, 53);
		painelBotoes.add(btnAdicionar);

		JButton btnEditar = new JButton("");
		
		// Evento do 'btnEditar' para abrir o 'FrmClientes'
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirJanelaCliente("EDITAR");
			}
		});
		btnEditar.setBackground(new Color(255, 255, 255));
		btnEditar.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/jandira/sp/images/editar.png")));
		btnEditar.setBounds(100, 11, 65, 53);
		painelBotoes.add(btnEditar);

		JButton btnExcluir = new JButton("");
		
		// Evento do 'btnExcluir' para abrir o 'FrmClientes'
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirJanelaCliente("EXCLUIR");
			}
		});
		btnExcluir.setBackground(new Color(255, 255, 255));
		btnExcluir.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/jandira/sp/images/deletar.png")));
		btnExcluir.setBounds(189, 11, 65, 53);
		painelBotoes.add(btnExcluir);
		
		// Evento do 'btnSair' para encerrar a aplicação
		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja encerrar a aplicação?",
						"Atenção", JOptionPane.YES_NO_OPTION);

				if (resposta == 0) {
					dispose();
				}

			}
		});
		btnSair.setBackground(new Color(255, 255, 255));
		btnSair.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/jandira/sp/images/sair.png")));
		btnSair.setBounds(401, 11, 65, 53);
		painelBotoes.add(btnSair);
	}
	
	// Método para criar uma tabela
	public void criarTabela() {
		scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 20, 455, 114);
		painelTabela.add(scrollTabela);

		tabelaClientes = new JTable();

		DefaultTableModel modeloTabela = new DefaultTableModel();
		String[] nomesColunas = { "CPF", "NOME", "E-MAIL" };
		modeloTabela.setColumnIdentifiers(nomesColunas);

		ClienteDAO clienteDAO = new ClienteDAO();
		ArrayList<Cliente> clientes = new ArrayList<>();

		clientes = clienteDAO.getClientes();

		Object[] linha = new Object[3];

		for (Cliente cliente : clientes) {
			linha[0] = cliente.getCpf();
			linha[1] = cliente.getNome();
			linha[2] = cliente.getEmail();

			modeloTabela.addRow(linha);
		}
		tabelaClientes.setModel(modeloTabela);
		tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(120);
		tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(210);
		tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(190);
		scrollTabela.setViewportView(tabelaClientes);
	}
	
	// Método para selecionar um cliente na tabela e puxar seus dados no Banco de Dados
	public void abrirJanelaCliente(String operacao) {
		try {
			int linha;
			linha = tabelaClientes.getSelectedRow();

			String cpf;
			cpf = (String) tabelaClientes.getValueAt(linha, 0);

			ClienteDAO clienteDAO = new ClienteDAO();
			Cliente cliente = clienteDAO.getCliente(cpf);
			
			int altura;
			int peso;
			
			// Convertendo os atributos 'altura' e 'peso' em inteiros
			altura = (int) cliente.getAltura();
			peso = (int) cliente.getPeso();

			FrmClientes frmClientes = new FrmClientes(operacao);
			frmClientes.setTxtCpf(cliente.getCpf());
			frmClientes.setTxtNome(cliente.getNome());
			frmClientes.setTxtEmail(cliente.getEmail());
			frmClientes.setTxtDtNasc(String.valueOf(cliente.getDtNasc()));
			frmClientes.setTxtAltura(String.valueOf(altura));
			frmClientes.setTxtPeso(String.valueOf(peso));
			frmClientes.setSexo(cliente.getSexo());
			frmClientes.setCbAtividade(cliente.getAtividade());

			frmClientes.setVisible(true);
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Selecione um contato!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
