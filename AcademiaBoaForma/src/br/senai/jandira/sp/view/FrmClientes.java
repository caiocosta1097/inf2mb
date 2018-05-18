package br.senai.jandira.sp.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.senai.jandira.sp.dao.ClienteDAO;
import br.senai.jandira.sp.model.Cliente;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

public class FrmClientes extends JFrame {

	private JPanel painelPrincipal;
	private JTextField txtNome;
	private JFormattedTextField txtCpf;
	private JTextField txtEmail;
	private JFormattedTextField txtDtNasc;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JRadioButton btnRadioHomem;
	private JRadioButton btnRadioMulher;
	private ButtonGroup btnGrupoSexo;
	private JComboBox cbAtividade;
	private JLabel lblRespostaIdade;
	private JLabel lblRespostaImc;
	private JTextPane TxtCaixaImc;
	private JLabel lblRespostaFcm;
	private JLabel lblRespostaTmb;
	private FrmAcademia frmAcademia;

	// Métodos setters do 'FrmClientes' para os campos
	public void setTxtNome(String nome) {
		this.txtNome.setText(nome);
	}

	public void setTxtCpf(String cpf) {
		this.txtCpf.setText(cpf);
	}

	public void setTxtEmail(String email) {
		this.txtEmail.setText(email);
	}

	public void setTxtDtNasc(String dtNasc) {
		this.txtDtNasc.setText(dtNasc);
	}

	public void setTxtAltura(String altura) {
		this.txtAltura.setText(altura);
	}

	public void setTxtPeso(String peso) {
		this.txtPeso.setText(peso);
	}

	public void setSexo(String sexo) {
		if (sexo.equals("M")) {
			btnRadioHomem.setSelected(true);
		} else {
			btnRadioMulher.setSelected(true);
		}
	}

	public void setCbAtividade(String atividade) {
		this.cbAtividade.setSelectedItem(atividade);
	}

	// Método construtor de 'FrmClientes'
	public FrmClientes(String operacao) {
		setTitle("Cliente");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(FrmClientes.class.getResource("/br/senai/jandira/sp/images/academia.png")));
		setResizable(false);
		setBounds(100, 100, 334, 608);
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(83, 125, 193));
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);

		JPanel painelTitulo = new JPanel();
		painelTitulo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), null));
		painelTitulo.setBackground(new Color(83, 125, 193));
		painelTitulo.setBounds(-5, 0, 338, 64);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);

		JLabel lblTitulo = new JLabel(" Boa Forma");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Monotype Corsiva", Font.BOLD, 39));
		lblTitulo.setBounds(0, 0, 195, 64);
		painelTitulo.add(lblTitulo);

		JLabel lblOperacao = new JLabel(operacao);
		lblOperacao.setBackground(new Color(255, 255, 255));
		lblOperacao.setHorizontalAlignment(SwingConstants.CENTER);

		/*
		 * Mudando a cor do 'lblOperacao' para vermelho se for para deletar ou
		 * verde se for para adicionar ou editar
		 */
		if (operacao.equals("EXCLUIR")) {
			lblOperacao.setForeground(new Color(224, 48, 42));
		} else {
			lblOperacao.setForeground(new Color(48, 224, 42));
		}

		lblOperacao.setFont(new Font("Verdana", Font.BOLD, 18));
		lblOperacao.setBounds(205, 2, 126, 64);
		painelTitulo.add(lblOperacao);

		JPanel painelDados = new JPanel();
		painelDados.setBorder(
				new TitledBorder(new LineBorder(null), "Dados:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelDados.setBackground(new Color(216, 235, 255));
		painelDados.setBounds(10, 75, 310, 265);
		painelPrincipal.add(painelDados);
		painelDados.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNome.setBounds(10, 22, 46, 14);
		painelDados.add(lblNome);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblCpf.setBounds(195, 22, 46, 14);
		painelDados.add(lblCpf);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblEmail.setBounds(10, 77, 46, 14);
		painelDados.add(lblEmail);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblSexo.setBounds(10, 131, 46, 14);
		painelDados.add(lblSexo);

		JLabel lblDtNasc = new JLabel("Data Nascimento:");
		lblDtNasc.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblDtNasc.setHorizontalAlignment(SwingConstants.CENTER);
		lblDtNasc.setBounds(201, 77, 105, 14);
		painelDados.add(lblDtNasc);

		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblAltura.setBounds(10, 156, 46, 14);
		painelDados.add(lblAltura);

		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblPeso.setBounds(68, 156, 46, 14);
		painelDados.add(lblPeso);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtNome.setBounds(10, 41, 175, 30);
		painelDados.add(txtNome);
		txtNome.setColumns(10);

		MaskFormatter cpfMask = null;

		// formatando uma máscara para o 'txtCpf'
		try {
			cpfMask = new MaskFormatter("###.###.###-##");
			cpfMask.setPlaceholderCharacter('0');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtCpf = new JFormattedTextField(cpfMask);
		txtCpf.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtCpf.setBounds(195, 41, 105, 30);
		painelDados.add(txtCpf);
		txtCpf.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtEmail.setBounds(10, 96, 181, 30);
		painelDados.add(txtEmail);
		txtEmail.setColumns(10);

		MaskFormatter dataMask = null;

		// formatando uma máscara para o 'txtDtNasc'
		try {
			dataMask = new MaskFormatter("##/##/####");
			dataMask.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtDtNasc = new JFormattedTextField(dataMask);
		txtDtNasc.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtDtNasc.setBounds(211, 96, 82, 30);
		painelDados.add(txtDtNasc);
		txtDtNasc.setColumns(10);

		btnRadioHomem = new JRadioButton("Homem");
		btnRadioHomem.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnRadioHomem.setBackground(new Color(216, 235, 255));
		btnRadioHomem.setBounds(49, 127, 76, 23);
		btnRadioHomem.setActionCommand("M");
		painelDados.add(btnRadioHomem);

		btnRadioMulher = new JRadioButton("Mulher");
		btnRadioMulher.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnRadioMulher.setBackground(new Color(216, 235, 255));
		btnRadioMulher.setBounds(127, 127, 65, 23);
		btnRadioMulher.setActionCommand("F");
		painelDados.add(btnRadioMulher);

		btnGrupoSexo = new ButtonGroup();
		btnGrupoSexo.add(btnRadioHomem);
		btnGrupoSexo.add(btnRadioMulher);

		txtAltura = new JTextField();

		// Evento para aceitar somento números no 'txtAltura'
		txtAltura.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String numeros = "0987654321";

				if (!numeros.contains(e.getKeyChar() + "")) {

					e.consume();

				}
			}
		});
		txtAltura.setBounds(10, 175, 34, 25);
		painelDados.add(txtAltura);
		txtAltura.setColumns(10);

		txtPeso = new JTextField();

		// Evento para aceitar somento números no 'txtPeso'
		txtPeso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String numeros = "0987654321";

				if (!numeros.contains(e.getKeyChar() + "")) {

					e.consume();

				}
			}
		});
		txtPeso.setColumns(10);
		txtPeso.setBounds(68, 175, 34, 25);
		painelDados.add(txtPeso);

		JLabel lblCm = new JLabel("cm");
		lblCm.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblCm.setBounds(47, 180, 18, 14);
		painelDados.add(lblCm);

		JLabel lblQuilos = new JLabel("kg");
		lblQuilos.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblQuilos.setBounds(105, 180, 24, 14);
		painelDados.add(lblQuilos);

		JLabel lblAtividade = new JLabel("N\u00EDvel de Atividade:");
		lblAtividade.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblAtividade.setBounds(151, 156, 125, 14);
		painelDados.add(lblAtividade);

		cbAtividade = new JComboBox();
		cbAtividade.setFont(new Font("Verdana", Font.PLAIN, 11));
		cbAtividade.setModel(new DefaultComboBoxModel(new String[] { "Sedent\u00E1rio ", "Levemente Ativo",
				"Moderadamente Ativo", "Bastante Ativo", "Muito Ativo" }));
		cbAtividade.setBounds(151, 175, 149, 20);
		painelDados.add(cbAtividade);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente cliente = new Cliente();

				// formatar para até uma casa decimal
				DecimalFormat decimal = new DecimalFormat("0.#");

				SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
				Date dtAtual = new Date();
				try {
					Date dtBanco = data.parse(txtDtNasc.getText());

					// Código para subtrair duas datas
					long diferencaDatas = dtAtual.getTime() - dtBanco.getTime();
					Long diferencaAnos = diferencaDatas / 1000 / 60 / 60 / 24 / 365;

					int idade = Integer.valueOf(diferencaAnos.intValue());

					/*
					 * pegando os valores dos campos e dar um set nos atributos:
					 * 'idade', 'altura', 'peso', 'sexo' e 'atividade'
					 */
					cliente.setIdade(idade);
					cliente.setAltura(Double.parseDouble(txtAltura.getText()));
					cliente.setPeso(Double.parseDouble(txtPeso.getText()));
					cliente.setSexo(btnGrupoSexo.getSelection().getActionCommand());
					cliente.setAtividade(cbAtividade.getSelectedItem().toString());

					int fcm;

					// Convertendo o atributo 'fcm' em inteiro
					fcm = (int) cliente.fcm();

					lblRespostaIdade.setText(String.valueOf(cliente.getIdade() + " anos"));

					lblRespostaImc.setText(String.valueOf(decimal.format(cliente.imc()) + " kg/m²"));

					TxtCaixaImc.setText(cliente.getRespostaImc());

					lblRespostaTmb.setText(String.valueOf(decimal.format(cliente.tmb()) + " kcal"));

					lblRespostaFcm.setText(String.valueOf(fcm) + " bpm");

				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
				}
			}
		});
		btnCalcular
				.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/senai/jandira/sp/images/calculadora.png")));
		btnCalcular.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnCalcular.setBounds(68, 213, 159, 41);
		painelDados.add(btnCalcular);

		JPanel painelResultados = new JPanel();
		painelResultados.setBorder(new TitledBorder(new LineBorder(null), "Resultados:", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		painelResultados.setBackground(new Color(216, 235, 255));
		painelResultados.setBounds(10, 344, 310, 170);
		painelPrincipal.add(painelResultados);
		painelResultados.setLayout(null);

		JLabel lblImc = new JLabel("IMC:");
		lblImc.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblImc.setBounds(10, 22, 38, 14);
		painelResultados.add(lblImc);

		JLabel lblTmb = new JLabel("TMB:");
		lblTmb.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblTmb.setBounds(10, 116, 38, 14);
		painelResultados.add(lblTmb);

		JLabel lblFcm = new JLabel("FCM:");
		lblFcm.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblFcm.setBounds(10, 141, 39, 14);
		painelResultados.add(lblFcm);

		lblRespostaImc = new JLabel("-");
		lblRespostaImc.setFont(new Font("Verdana", Font.BOLD, 11));
		lblRespostaImc.setBounds(59, 22, 111, 14);
		painelResultados.add(lblRespostaImc);

		lblRespostaFcm = new JLabel("-");
		lblRespostaFcm.setFont(new Font("Verdana", Font.BOLD, 11));
		lblRespostaFcm.setBounds(59, 141, 238, 14);
		painelResultados.add(lblRespostaFcm);

		lblRespostaTmb = new JLabel("-");
		lblRespostaTmb.setFont(new Font("Verdana", Font.BOLD, 11));
		lblRespostaTmb.setBounds(59, 116, 238, 14);
		painelResultados.add(lblRespostaTmb);

		TxtCaixaImc = new JTextPane();
//		TxtCaixaImc.setWrapStyleWord(true);
//		TxtCaixaImc.setLineWrap(true);
		TxtCaixaImc.setEditable(false);
		TxtCaixaImc.setFont(new Font("Verdana", Font.PLAIN, 11));
		TxtCaixaImc.setBounds(59, 47, 238, 58);
		painelResultados.add(TxtCaixaImc);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblIdade.setBounds(183, 22, 46, 14);
		painelResultados.add(lblIdade);

		lblRespostaIdade = new JLabel("-");
		lblRespostaIdade.setFont(new Font("Verdana", Font.BOLD, 11));
		lblRespostaIdade.setBounds(239, 22, 61, 14);
		painelResultados.add(lblRespostaIdade);

		JButton btnSair = new JButton("");
		btnSair.setToolTipText("Sair");

		// Evento do 'btnSair' para fechar o 'FrmClientes'
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção",
						JOptionPane.YES_NO_OPTION);

				if (resposta == 0) {
					dispose();
				}
			}
		});
		btnSair.setBounds(254, 520, 58, 52);
		painelPrincipal.add(btnSair);
		btnSair.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/senai/jandira/sp/images/sair.png")));

		JButton btnDinamico = new JButton("");
		btnDinamico.setBounds(20, 520, 58, 52);
		painelPrincipal.add(btnDinamico);
		btnDinamico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS");

				Date usuarioDate = null;
				String dateBanco = null;

				// Pegando os valores dos campos e inserindo no Banco de Dados
				try {
					usuarioDate = data.parse(txtDtNasc.getText());
					dateBanco = formatoBanco.format(usuarioDate);

					Cliente cliente = new Cliente();
					cliente.setCpf(txtCpf.getText());
					cliente.setNome(txtNome.getText());
					cliente.setEmail(txtEmail.getText());
					cliente.setSexo(btnGrupoSexo.getSelection().getActionCommand());
					cliente.setDtNasc(dateBanco);
					cliente.setAltura(Double.parseDouble(txtAltura.getText()));
					cliente.setPeso(Double.parseDouble(txtPeso.getText()));
					cliente.setAtividade(cbAtividade.getSelectedItem().toString());

					ClienteDAO clienteDAO = new ClienteDAO();
					clienteDAO.setCliente(cliente);

					/*
					 * Chamar os métodos: 'gravar()', 'atualizar()' ou
					 * 'excluir()' dependendo do 'lblOperacao'
					 */
					if (lblOperacao.getText().equals("NOVO")) {
						clienteDAO.gravar();
						limpar();

					} else if (lblOperacao.getText().equals("EDITAR")) {
						clienteDAO.atualizar(txtCpf.getText());
					} else if (lblOperacao.getText().equals("EXCLUIR")) {
						int resposta = JOptionPane.showConfirmDialog(null,
								"Tem certeza que deseja excluir " + cliente.getNome() + "?", "Atenção",
								JOptionPane.YES_NO_OPTION);

						if (resposta == 0) {
							clienteDAO.excluir(txtCpf.getText());
							dispose();
						}
					}
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
				}
				
				// Chamando o método do outro JFrame
				frmAcademia.atualizarTabela();
			}
		});

		// Mudar o ícone se o 'lblOperacao' for 'EXCLUIR'
		if (operacao.equals("EXCLUIR")) {
			btnDinamico
					.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/senai/jandira/sp/images/deletar.png")));
			btnDinamico.setToolTipText("Excluir");

		} else {
			btnDinamico.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/senai/jandira/sp/images/salvar.png")));
			btnDinamico.setToolTipText("Salvar");
		}

		// Bloquear o 'txtCpf' se for 'EDITAR'
		if (operacao.equals("EDITAR")) {
			txtCpf.setEnabled(false);

			// Bloquear todos os campos e 'btnCalcular' se for 'EXCLUIR'
		} else if (operacao.equals("EXCLUIR")) {
			txtCpf.setEnabled(false);
			txtNome.setEnabled(false);
			txtDtNasc.setEnabled(false);
			txtEmail.setEnabled(false);
			txtAltura.setEnabled(false);
			txtPeso.setEnabled(false);
			btnRadioHomem.setEnabled(false);
			btnRadioMulher.setEnabled(false);
			cbAtividade.setEnabled(false);
			btnCalcular.setEnabled(false);
		}
	}

	// Limpar os campos após usar o método 'gravar()'
	private void limpar() {
		txtCpf.setText("");
		txtNome.setText("");
		txtEmail.setText("");
		txtDtNasc.setText("");
		txtAltura.setText("");
		txtPeso.setText("");
		btnGrupoSexo.clearSelection();
		cbAtividade.setSelectedIndex(0);
		lblRespostaImc.setText("-");
		TxtCaixaImc.setText("");
		lblRespostaIdade.setText("-");
		lblRespostaTmb.setText("-");
		lblRespostaFcm.setText("-");
		txtNome.requestFocus();
	}
	
	// Método para abrir o 'FrmClientes' e vincular com 'FrmAcademia'
	public void criarFrmClientes(FrmAcademia frmAcademia){
		this.frmAcademia = frmAcademia;
		setVisible(true);
	}
}
