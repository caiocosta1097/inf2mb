package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.border.EtchedBorder;

import br.senai.sp.jandira.dao.ContatoDAO;
import br.senai.sp.jandira.model.Contato;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class FrmContato extends JFrame {

	private JPanel painelPrincipal;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtCelular;
	private JTextField txtDataNascimento;
	private JTextField txtTelefone;
	private JTextArea txtEndereco;
	private JComboBox cbSexo;

	public void setTxtId(String id) {
		this.txtId.setText(id);;
	}

	public void setTxtNome(String nome) {
		this.txtNome.setText(nome);
	}

	public void setTxtEmail(String email) {
		this.txtEmail.setText(email);;
	}

	public void setTxtCelular(String celular) {
		this.txtCelular.setText(celular);;
	}

	public void setTxtDataNascimento(String dataNascimento) {
		this.txtDataNascimento.setText(dataNascimento);;
	}

	public void setTxtTelefone(String telefone) {
		this.txtTelefone.setText(telefone);;
	}

	public void setTxtEndereco(String endereco) {
		this.txtEndereco.setText(endereco);
	}
	
	public void setCbSexo(String sexo) {
		this.cbSexo.setSelectedItem(sexo);
	}

	public FrmContato(String operacao) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(FrmContato.class.getResource("/br/senai/sp/jandira/view/calendar (1).png")));
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

		JLabel lblOperacao = new JLabel(operacao);
		lblOperacao.setForeground(new Color(0, 128, 0));
		lblOperacao.setFont(new Font("Verdana", Font.BOLD, 16));
		lblOperacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperacao.setBounds(253, 11, 98, 36);
		painelTitulo.add(lblOperacao);

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

		txtEndereco = new JTextArea();
		txtEndereco.setLineWrap(true);
		txtEndereco.setWrapStyleWord(true);
		scrollEndereco.setViewportView(txtEndereco);

		cbSexo = new JComboBox();
		cbSexo.setModel(new DefaultComboBoxModel(new String[] { "F", "M" }));
		cbSexo.setBounds(294, 100, 37, 20);
		painelDados.add(cbSexo);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSexo.setBounds(252, 103, 40, 14);
		painelDados.add(lblSexo);

		JPanel painelBotao = new JPanel();
		painelBotao.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelBotao.setBounds(10, 297, 341, 68);
		painelPrincipal.add(painelBotao);
		painelBotao.setLayout(null);

		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Contato contato = new Contato();
				contato.setNome(txtNome.getText());
				contato.setEmail(txtEmail.getText());
				contato.setCelular(txtCelular.getText());
				contato.setDtNascimento(txtDataNascimento.getText());
				contato.setTelefone(txtTelefone.getText());
				contato.setEndereco(txtEndereco.getText());
				contato.setSexo(cbSexo.getSelectedItem().toString());

				ContatoDAO contatoDao = new ContatoDAO();
				contatoDao.setContato(contato);

				if (lblOperacao.getText().equals("NOVO")) {
					contatoDao.gravar();
					limpar();
				}
				else if (lblOperacao.getText().equals("EDITAR")) {
					contatoDao.atualizar();
				}
				else if (lblOperacao.getText().equals("EXCLUIR")){
					contatoDao.excluir();
					limpar();
				}

			}
		});
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

	private void limpar() {
		txtId.setText("");
		txtNome.setText("");
		txtEmail.setText("");
		txtCelular.setText("");
		txtTelefone.setText("");
		txtDataNascimento.setText("");
		txtEndereco.setText("");
		txtNome.requestFocus();
	}
}
