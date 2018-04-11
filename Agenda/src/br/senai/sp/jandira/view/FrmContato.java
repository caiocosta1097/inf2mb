package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class FrmContato extends JFrame {

	private JPanel painelPrincipal;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtCelular;
	private JTextField txtDataNascimento;
	private JTextField txtTelefone;

	public FrmContato(String operacao) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmContato.class.getResource("/br/senai/sp/jandira/view/calendar (1).png")));
		setBounds(100, 100, 377, 415);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(new Color(255, 228, 225));
		painelTitulo.setBounds(0, 0, 361, 62);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblContatos = new JLabel(" Contatos");
		lblContatos.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/view/contatos.png")));
		lblContatos.setFont(new Font("Verdana", Font.BOLD, 32));
		lblContatos.setBounds(10, 11, 215, 40);
		painelTitulo.add(lblContatos);
		
		JLabel lblNovo = new JLabel(operacao);
		lblNovo.setForeground(new Color(0, 128, 0));
		lblNovo.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNovo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovo.setBounds(253, 11, 98, 36);
		painelTitulo.add(lblNovo);
		
		JPanel painelDados = new JPanel();
		painelDados.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelDados.setBounds(10, 70, 341, 216);
		painelPrincipal.add(painelDados);
		painelDados.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(10, 11, 16, 14);
		painelDados.add(lblId);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(70, 11, 40, 14);
		painelDados.add(lblNome);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(10, 42, 40, 14);
		painelDados.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefone.setBounds(10, 67, 62, 14);
		painelDados.add(lblTelefone);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCelular.setBounds(172, 67, 55, 14);
		painelDados.add(lblCelular);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEndereo.setBounds(10, 128, 62, 14);
		painelDados.add(lblEndereo);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(30, 8, 30, 20);
		painelDados.add(txtId);
		txtId.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(108, 8, 223, 20);
		painelDados.add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(56, 39, 275, 20);
		painelDados.add(txtEmail);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(66, 64, 96, 20);
		painelDados.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(219, 64, 112, 20);
		painelDados.add(txtCelular);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataDeNascimento.setBounds(10, 103, 122, 14);
		painelDados.add(lblDataDeNascimento);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setBounds(133, 100, 86, 20);
		painelDados.add(txtDataNascimento);
		txtDataNascimento.setColumns(10);
		
		JScrollPane scrollEndereco = new JScrollPane();
		scrollEndereco.setBounds(70, 128, 157, 77);
		painelDados.add(scrollEndereco);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setLineWrap(true);
		txtArea.setWrapStyleWord(true);
		scrollEndereco.setViewportView(txtArea);
		
		JPanel painelBotao = new JPanel();
		painelBotao.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelBotao.setBounds(10, 297, 341, 68);
		painelPrincipal.add(painelBotao);
		painelBotao.setLayout(null);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setBackground(new Color(255, 228, 225));
		btnSalvar.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/view/salvar.png")));
		btnSalvar.setBounds(10, 11, 59, 46);
		painelBotao.add(btnSalvar);
		
		JButton btnSair = new JButton("");
		btnSair.setBackground(new Color(255, 228, 225));
		btnSair.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/view/sair.png")));
		btnSair.setBounds(272, 11, 59, 46);
		painelBotao.add(btnSair);
	}
}
