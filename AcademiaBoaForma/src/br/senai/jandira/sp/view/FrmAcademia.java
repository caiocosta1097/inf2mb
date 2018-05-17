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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

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
	private DefaultTableModel modeloTabela;

	// Método construtor de 'FrmAcademia'
	public FrmAcademia() {
		setResizable(false);
		setTitle("Boa Forma");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(FrmAcademia.class.getResource("/br/senai/jandira/sp/images/academia.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(83, 125, 193));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);

		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(new Color(83, 125, 193));
		painelTitulo.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		painelTitulo.setBounds(0, 0, 494, 64);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);

		JLabel lblTitulo = new JLabel(" Boa Forma");
		lblTitulo.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/jandira/sp/images/academia.png")));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		lblTitulo.setBounds(10, 0, 379, 64);
		painelTitulo.add(lblTitulo);

		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

		// Inserindo a data de hoje no 'lblData'
		JLabel lblData = new JLabel("");
		lblData.setFont(new Font("Verdana", Font.BOLD, 11));
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setBounds(394, 11, 90, 14);
		Date dataAtual = new Date();
		lblData.setText(data.format(dataAtual));
		painelTitulo.add(lblData);

		painelTabela = new JPanel();
		painelTabela.setBorder(new TitledBorder(new LineBorder(null), "Clientes:", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		painelTabela.setBackground(new Color(216, 235, 255));
		painelTabela.setBounds(10, 75, 475, 210);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);

		// Chamando o 'criarTabela()'
		criarTabela();

		JPanel painelBotoes = new JPanel();
		painelBotoes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelBotoes.setBackground(new Color(83, 125, 193));
		painelBotoes.setBounds(0, 296, 494, 75);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);

		JButton btnAdicionar = new JButton("");
		btnAdicionar.setToolTipText("Adicionar cliente");

		// Evento do 'btnAdicionar' para abrir o 'FrmClientes'
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmClientes frmClientes = new FrmClientes("NOVO");
				frmClientes.setVisible(true);
				
			}
		});
		btnAdicionar
				.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/jandira/sp/images/add_cliente.png")));
		btnAdicionar.setBounds(10, 11, 65, 53);
		painelBotoes.add(btnAdicionar);

		JButton btnEditar = new JButton("");
		btnEditar.setToolTipText("Editar cliente");

		// Evento do 'btnEditar' para abrir o 'FrmClientes'
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirJanelaCliente("EDITAR");
			}
		});
		btnEditar.setIcon(
				new ImageIcon(FrmAcademia.class.getResource("/br/senai/jandira/sp/images/editar_cliente.png")));
		btnEditar.setBounds(100, 11, 65, 53);
		painelBotoes.add(btnEditar);

		JButton btnExcluir = new JButton("");
		btnExcluir.setToolTipText("Excluir cliente");

		// Evento do 'btnExcluir' para abrir o 'FrmClientes'
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirJanelaCliente("EXCLUIR");
			}
		});
		btnExcluir.setIcon(
				new ImageIcon(FrmAcademia.class.getResource("/br/senai/jandira/sp/images/deletar_cliente.png")));
		btnExcluir.setBounds(190, 11, 65, 53);
		painelBotoes.add(btnExcluir);

		// Evento do 'btnSair' para encerrar a aplicação
		JButton btnSair = new JButton("");
		btnSair.setToolTipText("Encerrar aplica\u00E7\u00E3o");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja encerrar a aplicação?",
						"Atenção", JOptionPane.YES_NO_OPTION);

				if (resposta == 0) {
					dispose();
				}

			}
		});
		btnSair.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/jandira/sp/images/sair.png")));
		btnSair.setBounds(401, 11, 65, 53);
		painelBotoes.add(btnSair);
		
		JButton btnAtualizar = new JButton("");
		btnAtualizar.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/jandira/sp/images/atualizar.png")));
		btnAtualizar.setToolTipText("Atualizar tabela");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizarTabela();
			}
		});
		btnAtualizar.setBounds(280, 11, 65, 53);
		painelBotoes.add(btnAtualizar);
	}

	// Método para criar uma tabela
	public void criarTabela() {
		scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 20, 455, 179);
		painelTabela.add(scrollTabela);
		
		tabelaClientes = new JTable();

		modeloTabela = new DefaultTableModel() {

			// Deixar as células da tabela não editáveis
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
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
		
		// Deixar as colunas da tabela fixas
		tabelaClientes.getTableHeader().setReorderingAllowed(false);
		
		// Deixar o cabeçalho centralizado
		((DefaultTableCellRenderer) tabelaClientes.getTableHeader().getDefaultRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		
		tabelaClientes.getColumnModel().getColumn(0).setMinWidth(100);
		tabelaClientes.getColumnModel().getColumn(1).setMinWidth(170);
		tabelaClientes.getColumnModel().getColumn(2).setMinWidth(190);
		tabelaClientes.setFont(new Font("Verdana", Font.PLAIN, 11));
		scrollTabela.setViewportView(tabelaClientes);
		scrollTabela.getViewport().setBackground(new Color(255, 255, 255));
	}
	
	public void atualizarTabela(){
		DefaultTableModel modelo = (DefaultTableModel)tabelaClientes.getModel();
		modeloTabela.setRowCount(0);
		
		modelo = new DefaultTableModel() {

			// Deixar as células da tabela não editáveis
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		String[] nomesColunas = { "CPF", "NOME", "E-MAIL" };
		modelo.setColumnIdentifiers(nomesColunas);

		ClienteDAO clienteDAO = new ClienteDAO();
		ArrayList<Cliente> clientes = new ArrayList<>();

		clientes = clienteDAO.getClientes();

		Object[] linha = new Object[3];
		
		for (Cliente cliente : clientes) {
			linha[0] = cliente.getCpf();
			linha[1] = cliente.getNome();
			linha[2] = cliente.getEmail();

			modelo.addRow(linha);
		}
		tabelaClientes.setModel(modelo);
		
		// Deixar as colunas da tabela fixas
		tabelaClientes.getTableHeader().setReorderingAllowed(false);
		
		// Deixar o cabeçalho centralizado
		((DefaultTableCellRenderer) tabelaClientes.getTableHeader().getDefaultRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		
		tabelaClientes.getColumnModel().getColumn(0).setMinWidth(100);
		tabelaClientes.getColumnModel().getColumn(1).setMinWidth(170);
		tabelaClientes.getColumnModel().getColumn(2).setMinWidth(190);
		tabelaClientes.setFont(new Font("Verdana", Font.PLAIN, 11));
		scrollTabela.setViewportView(tabelaClientes);
		scrollTabela.getViewport().setBackground(new Color(255, 255, 255));
	}
	
	/*
	 * Método para selecionar um cliente na tabela e puxar seus dados no Banco
	 * de Dados
	 */
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
