package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.senai.sp.jandira.dao.ContatoDAO;
import br.senai.sp.jandira.model.Contato;

import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FrmAgenda extends JFrame {

	private JPanel painelPrincipal;
	private JTable tabelaContatos;
	private JScrollPane scrollTabela;
	private JPanel painelTabela;

	public FrmAgenda() {
		setBackground(new Color(255, 228, 225));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(FrmAgenda.class.getResource("/br/senai/sp/jandira/view/calendar (1).png")));
		setTitle("Agenda de Contatos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 387);
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(255, 228, 225));
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);

		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(new Color(255, 228, 225));
		painelTitulo.setBounds(0, 0, 458, 62);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);

		JLabel lblTitulo = new JLabel(" Agenda");
		lblTitulo.setBackground(new Color(255, 228, 225));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/view/calendar (1).png")));
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 32));
		lblTitulo.setBounds(10, 11, 438, 40);
		painelTitulo.add(lblTitulo);

		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

		JLabel lblData = new JLabel();
		lblData.setBounds(385, 11, 63, 14);
		Date dataAtual = new Date();
		lblData.setText(data.format(dataAtual));
		painelTitulo.add(lblData);

		painelTabela = new JPanel();
		painelTabela.setBackground(new Color(255, 228, 225));
		painelTabela.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Contatos:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		painelTabela.setBounds(10, 73, 438, 190);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);

		montarTabela();

		JPanel painelBotoes = new JPanel();
		painelBotoes.setBackground(new Color(255, 228, 225));
		painelBotoes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelBotoes.setBounds(10, 274, 438, 63);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);

		JButton btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmContato contato = new FrmContato("NOVO");
				contato.setVisible(true);
			}
		});
		btnNovo.setToolTipText("Adicionar contato");
		btnNovo.setBackground(Color.WHITE);
		btnNovo.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/view/adicionar.png")));
		btnNovo.setBounds(10, 11, 80, 41);
		painelBotoes.add(btnNovo);

		JButton btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirJanelaContato("EXCLUIR");
			}
		});
		btnExcluir.setToolTipText("Excluir contato");
		btnExcluir.setBackground(Color.WHITE);
		btnExcluir.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/view/deletar.png")));
		btnExcluir.setBounds(220, 11, 80, 41);
		painelBotoes.add(btnExcluir);

		JButton btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				abrirJanelaContato("EDITAR");
			}
		});
		btnEditar.setToolTipText("Editar contato");
		btnEditar.setBackground(Color.WHITE);
		btnEditar.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/view/editar.png")));
		btnEditar.setBounds(115, 11, 80, 41);
		painelBotoes.add(btnEditar);

		JButton btnSair = new JButton("");
		btnSair.setToolTipText("Sair da Aplica\u00E7\u00E3o");
		btnSair.setBackground(Color.WHITE);
		btnSair.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/view/sair.png")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSair.setBounds(363, 11, 65, 41);
		painelBotoes.add(btnSair);

	}

	public void montarTabela() {
		scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 21, 418, 158);
		painelTabela.add(scrollTabela);

		tabelaContatos = new JTable();

		DefaultTableModel modeloTabela = new DefaultTableModel();
		String[] nomesColunas = { "ID", "NOME", "E-MAIL" };
		modeloTabela.setColumnIdentifiers(nomesColunas);

		ContatoDAO contatoDAO = new ContatoDAO();
		ArrayList<Contato> contatos = new ArrayList<>();

		contatos = contatoDAO.getContatos();

		Object[] linha = new Object[3];

		for (Contato contato : contatos) {
			linha[0] = contato.getId();
			linha[1] = contato.getNome();
			linha[2] = contato.getEmail();
			modeloTabela.addRow(linha);
		}

		tabelaContatos.setModel(modeloTabela);
		tabelaContatos.getColumnModel().getColumn(0).setPreferredWidth(25);
		tabelaContatos.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabelaContatos.getColumnModel().getColumn(2).setPreferredWidth(220);
		scrollTabela.setViewportView(tabelaContatos);
	}

	private void abrirJanelaContato(String operacao) {
		try {
			int linha;
			linha = tabelaContatos.getSelectedRow();

			int id;
			id = (int) tabelaContatos.getValueAt(linha, 0);

			ContatoDAO contatoDAO = new ContatoDAO();
			Contato contato = contatoDAO.getContato(id);

			FrmContato frmContato = new FrmContato(operacao);
			frmContato.setTxtId(String.valueOf(contato.getId()));
			frmContato.setTxtNome(contato.getNome());
			frmContato.setTxtCelular(contato.getCelular());
			frmContato.setTxtTelefone(contato.getTelefone());
			frmContato.setTxtDataNascimento(String.valueOf(contato.getDtNascimento()));
			frmContato.setTxtEmail(contato.getEmail());
			frmContato.setTxtEndereco(contato.getEndereco());
			frmContato.setCbSexo(contato.getSexo());

			frmContato.setVisible(true);
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Selecione um contato!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
