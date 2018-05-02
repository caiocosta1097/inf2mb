package br.senai.jandira.sp.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.util.ArrayList;

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
import java.awt.event.ActionEvent;

public class FrmAcademia extends JFrame {

	private JPanel painelPrincipal;
	private JTable tabelaClientes;
	private JScrollPane scrollTabela;
	private JPanel painelTabela;

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
		lblTitulo.setBounds(10, 0, 484, 64);
		painelTitulo.add(lblTitulo);

		painelTabela = new JPanel();
		painelTabela.setBorder(new TitledBorder(new LineBorder(null), "Clientes:", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(37, 183, 211)));
		painelTabela.setBackground(new Color(255, 255, 225));
		painelTabela.setBounds(10, 75, 475, 145);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);

		criarTabela();

		JPanel painelBotoes = new JPanel();
		painelBotoes.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		painelBotoes.setBackground(new Color(255, 255, 225));
		painelBotoes.setBounds(0, 231, 494, 75);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);

		JButton btnAdicionar = new JButton("");
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
		btnExcluir.setBackground(new Color(255, 255, 255));
		btnExcluir.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/jandira/sp/images/deletar.png")));
		btnExcluir.setBounds(189, 11, 65, 53);
		painelBotoes.add(btnExcluir);

		JButton btnSair = new JButton("");
		btnSair.setBackground(new Color(255, 255, 255));
		btnSair.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/jandira/sp/images/sair.png")));
		btnSair.setBounds(401, 11, 65, 53);
		painelBotoes.add(btnSair);
	}

	public void criarTabela() {
		scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 20, 455, 114);
		painelTabela.add(scrollTabela);

		tabelaClientes = new JTable();

		DefaultTableModel modeloTabela = new DefaultTableModel();
		String[] nomesColunas = { "ID", "NOME", "E-MAIL" };
		modeloTabela.setColumnIdentifiers(nomesColunas);

		ClienteDAO clienteDAO = new ClienteDAO();
		ArrayList<Cliente> clientes = new ArrayList<>();

		clientes = clienteDAO.getClientes();

		Object[] linha = new Object[3];

		for (Cliente cliente : clientes) {
			linha[0] = cliente.getId();
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

	public void abrirJanelaCliente(String operacao) {
		try{
			int linha;
			linha = tabelaClientes.getSelectedRow();
			
			int id;
			id = (int) tabelaClientes.getValueAt(linha, 0);
			
			ClienteDAO clienteDAO = new ClienteDAO();
			Cliente cliente = clienteDAO.getCliente(id);
			
			FrmClientes frmClientes = new FrmClientes(operacao);
			frmClientes.setTxtId(String.valueOf(cliente.getId()));
			frmClientes.setTxtNome(cliente.getNome());
			frmClientes.setTxtEmail(cliente.getEmail());
			frmClientes.setTxtDtNasc(String.valueOf(cliente.getDtNasc()));
			frmClientes.setTxtAltura(String.valueOf(cliente.getAltura()));
			frmClientes.setTxtPeso(String.valueOf(cliente.getPeso()));
			frmClientes.setSexo(cliente.getSexo());
			frmClientes.setCbAtividade(cliente.getAtividade());
			
			frmClientes.setVisible(true);
		} catch (Exception erro){
			JOptionPane.showMessageDialog(null, "Selecione um contato!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
