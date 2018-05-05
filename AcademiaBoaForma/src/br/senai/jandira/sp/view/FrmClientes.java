package br.senai.jandira.sp.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import br.senai.jandira.sp.dao.ClienteDAO;
import br.senai.jandira.sp.model.Cliente;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
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
	private JLabel lblRespostaFcm;
	private JLabel lblRespostaTmb;

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

	public FrmClientes(String operacao) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(FrmClientes.class.getResource("/br/senai/jandira/sp/images/academia.png")));
		setResizable(false);
		setBounds(100, 100, 334, 585);
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(255, 255, 225));
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);

		JPanel painelTitulo = new JPanel();
		painelTitulo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelTitulo.setBackground(new Color(255, 255, 255));
		painelTitulo.setBounds(0, 0, 744, 64);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);

		JLabel lblTitulo = new JLabel(" Boa Forma");
		lblTitulo.setForeground(new Color(37, 183, 211));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 26));
		lblTitulo.setBounds(0, 0, 166, 64);
		painelTitulo.add(lblTitulo);

		JLabel lblOperacao = new JLabel(operacao);
		lblOperacao.setHorizontalAlignment(SwingConstants.CENTER);
		if (operacao.equals("EXCLUIR")) {
			lblOperacao.setForeground(new Color(255, 0, 0));
		} else {
			lblOperacao.setForeground(new Color(0, 255, 0));
		}
		lblOperacao.setFont(new Font("Verdana", Font.BOLD, 20));
		lblOperacao.setBounds(172, 2, 159, 64);
		painelTitulo.add(lblOperacao);

		JPanel painelDados = new JPanel();
		painelDados.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Dados:", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(37, 183, 211)));
		painelDados.setBackground(new Color(255, 255, 225));
		painelDados.setBounds(10, 75, 310, 265);
		painelPrincipal.add(painelDados);
		painelDados.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 27, 46, 14);
		painelDados.add(lblNome);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(201, 27, 46, 14);
		painelDados.add(lblCpf);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 77, 46, 14);
		painelDados.add(lblEmail);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 127, 46, 14);
		painelDados.add(lblSexo);

		JLabel lblDtNasc = new JLabel("Data Nascimento:");
		lblDtNasc.setHorizontalAlignment(SwingConstants.CENTER);
		lblDtNasc.setBounds(201, 77, 105, 14);
		painelDados.add(lblDtNasc);

		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(10, 152, 46, 14);
		painelDados.add(lblAltura);

		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(68, 152, 46, 14);
		painelDados.add(lblPeso);

		txtNome = new JTextField();
		txtNome.setBounds(10, 46, 181, 20);
		painelDados.add(txtNome);
		txtNome.setColumns(10);

		MaskFormatter cpfMask = null;

		try {
			cpfMask = new MaskFormatter("###.###.###-##");
			cpfMask.setPlaceholderCharacter('0');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtCpf = new JFormattedTextField(cpfMask);
		txtCpf.setBounds(201, 46, 99, 20);
		painelDados.add(txtCpf);
		txtCpf.setColumns(10);

		if (operacao.equals("EDITAR") || operacao.equals("EXCLUIR")) {
			txtCpf.setEditable(false);
		}

		txtEmail = new JTextField();
		txtEmail.setBounds(10, 96, 181, 20);
		painelDados.add(txtEmail);
		txtEmail.setColumns(10);

		MaskFormatter dataMask = null;

		try {
			dataMask = new MaskFormatter("##/##/####");
			dataMask.setPlaceholderCharacter('0');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtDtNasc = new JFormattedTextField(dataMask);
		txtDtNasc.setBounds(218, 96, 70, 20);
		painelDados.add(txtDtNasc);
		txtDtNasc.setColumns(10);

		btnRadioHomem = new JRadioButton("Homem");
		btnRadioHomem.setBackground(new Color(255, 255, 225));
		btnRadioHomem.setBounds(49, 123, 76, 23);
		btnRadioHomem.setActionCommand("M");
		painelDados.add(btnRadioHomem);

		btnRadioMulher = new JRadioButton("Mulher");
		btnRadioMulher.setBackground(new Color(255, 255, 225));
		btnRadioMulher.setBounds(127, 123, 65, 23);
		btnRadioMulher.setActionCommand("F");
		painelDados.add(btnRadioMulher);

		btnGrupoSexo = new ButtonGroup();
		btnGrupoSexo.add(btnRadioHomem);
		btnGrupoSexo.add(btnRadioMulher);

		txtAltura = new JTextField();
		txtAltura.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String numeros = "0987654321";

				if (!numeros.contains(e.getKeyChar() + "")) {

					e.consume();

				}
			}
		});
		txtAltura.setBounds(10, 171, 34, 20);
		painelDados.add(txtAltura);
		txtAltura.setColumns(10);

		txtPeso = new JTextField();
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
		txtPeso.setBounds(68, 171, 34, 20);
		painelDados.add(txtPeso);

		JLabel lblCm = new JLabel("cm");
		lblCm.setBounds(47, 174, 18, 14);
		painelDados.add(lblCm);

		JLabel lblQuilos = new JLabel("quilos");
		lblQuilos.setBounds(105, 174, 34, 14);
		painelDados.add(lblQuilos);

		JLabel lblAtividade = new JLabel("N\u00EDvel de Atividade:");
		lblAtividade.setBounds(151, 152, 125, 14);
		painelDados.add(lblAtividade);

		cbAtividade = new JComboBox();
		cbAtividade.setModel(new DefaultComboBoxModel(new String[] { "Sedent\u00E1rio ", "Levemente Ativo",
				"Moderadamente Ativo", "Bastante Ativo", "Muito Ativo" }));
		cbAtividade.setBounds(151, 171, 149, 20);
		painelDados.add(cbAtividade);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente cliente = new Cliente();
				DecimalFormat decimal = new DecimalFormat("0.#");

				SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
				Date dtAtual = new Date();
				try {
					Date dtBanco = data.parse(txtDtNasc.getText());

					long diferencaDatas = dtAtual.getTime() - dtBanco.getTime();
					Long diferencaAnos = diferencaDatas / 1000 / 60 / 60 / 24 / 365;

					int idade = Integer.valueOf(diferencaAnos.intValue());

					cliente.setIdade(idade);
					lblRespostaIdade.setText(String.valueOf(cliente.getIdade() + " anos"));
				} catch (ParseException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
				}

				try {
					cliente.setAltura(Double.parseDouble(txtAltura.getText()));
					cliente.setPeso(Double.parseDouble(txtPeso.getText()));
					cliente.setSexo(btnGrupoSexo.getSelection().getActionCommand());
					cliente.setAtividade(cbAtividade.getSelectedItem().toString());

					int fcm;
					fcm = (int) cliente.fcm();

					lblRespostaImc.setText(String.valueOf(decimal.format(cliente.imc()) + " kg/m²"));
					lblRespostaTmb.setText(String.valueOf(decimal.format(cliente.tmb()) + " kcal"));
					lblRespostaFcm.setText(String.valueOf(fcm) + " bpm");

				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
				}
			}
		});
		btnCalcular
				.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/senai/jandira/sp/images/calculadora.png")));
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCalcular.setBackground(new Color(255, 255, 255));
		btnCalcular.setBounds(68, 213, 159, 41);
		painelDados.add(btnCalcular);

		JPanel painelResultados = new JPanel();
		painelResultados.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Resultados:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(37, 183, 211)));
		painelResultados.setBackground(new Color(255, 255, 225));
		painelResultados.setBounds(10, 344, 310, 140);
		painelPrincipal.add(painelResultados);
		painelResultados.setLayout(null);

		JLabel lblImc = new JLabel("IMC:");
		lblImc.setBounds(10, 22, 38, 14);
		painelResultados.add(lblImc);

		JLabel lblTmb = new JLabel("TMB:");
		lblTmb.setBounds(10, 90, 38, 14);
		painelResultados.add(lblTmb);

		JLabel lblFcm = new JLabel("FCM:");
		lblFcm.setBounds(10, 115, 39, 14);
		painelResultados.add(lblFcm);

		lblRespostaImc = new JLabel("-");
		lblRespostaImc.setBounds(62, 22, 111, 14);
		painelResultados.add(lblRespostaImc);

		lblRespostaFcm = new JLabel("-");
		lblRespostaFcm.setBounds(62, 115, 238, 14);
		painelResultados.add(lblRespostaFcm);

		lblRespostaTmb = new JLabel("-");
		lblRespostaTmb.setBounds(62, 90, 238, 14);
		painelResultados.add(lblRespostaTmb);

		JTextArea txtImc = new JTextArea();
		txtImc.setEditable(false);
		txtImc.setBounds(40, 37, 260, 42);
		painelResultados.add(txtImc);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(183, 22, 46, 14);
		painelResultados.add(lblIdade);

		lblRespostaIdade = new JLabel("-");
		lblRespostaIdade.setBounds(239, 22, 61, 14);
		painelResultados.add(lblRespostaIdade);

		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção",
						JOptionPane.YES_NO_OPTION);

				if (resposta == 0) {
					dispose();
				}
			}
		});
		btnSair.setBounds(254, 495, 58, 52);
		painelPrincipal.add(btnSair);
		btnSair.setBackground(new Color(255, 255, 255));
		btnSair.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/senai/jandira/sp/images/sair.png")));

		JButton btnDinamico = new JButton("");
		btnDinamico.setBounds(20, 495, 58, 52);
		painelPrincipal.add(btnDinamico);
		btnDinamico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SimpleDateFormat toDate = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat toDataBase = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS");

				Date usuarioDate = null;
				String dateBanco = null;

				try {
					usuarioDate = toDate.parse(txtDtNasc.getText());
					dateBanco = toDataBase.format(usuarioDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				try {
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

			}
		});

		if (operacao.equals("EXCLUIR")) {
			btnDinamico
					.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/senai/jandira/sp/images/deletar.png")));
		} else {
			btnDinamico.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/senai/jandira/sp/images/salvar.png")));
		}

		btnDinamico.setBackground(new Color(255, 255, 255));
	}

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
		lblRespostaIdade.setText("-");
		lblRespostaTmb.setText("-");
		lblRespostaFcm.setText("-");
		txtNome.requestFocus();
	}
}
