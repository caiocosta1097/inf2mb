package br.senai.jandira.sp.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import br.senai.jandira.sp.dao.ClienteDAO;
import br.senai.jandira.sp.model.Cliente;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FrmClientes extends JFrame {

	private JPanel painelPrincipal;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtDtNasc;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private ButtonGroup btnGrupoSexo;
	private JComboBox cbAtividade;

	public FrmClientes(String operacao) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmClientes.class.getResource("/br/senai/jandira/sp/images/academia.png")));
		setResizable(false);
		setBounds(100, 100, 750, 391);
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
		
		JLabel lblNewLabel = new JLabel(" Boa Forma");
		lblNewLabel.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/senai/jandira/sp/images/academia.png")));
		lblNewLabel.setForeground(new Color(37, 183, 211));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 32));
		lblNewLabel.setBounds(10, 0, 420, 64);
		painelTitulo.add(lblNewLabel);
		
		JLabel lblOperacao = new JLabel(operacao);
		lblOperacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperacao.setForeground(new Color(0, 204, 51));
		lblOperacao.setFont(new Font("Verdana", Font.BOLD, 26));
		lblOperacao.setBounds(440, 0, 294, 64);
		painelTitulo.add(lblOperacao);
		
		JPanel painelDados = new JPanel();
		painelDados.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Dados:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(37, 183, 211)));
		painelDados.setBackground(new Color(255, 255, 225));
		painelDados.setBounds(10, 75, 310, 276);
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
		
		txtCpf = new JTextField();
		txtCpf.setBounds(201, 46, 99, 20);
		painelDados.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(10, 96, 181, 20);
		painelDados.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtDtNasc = new JTextField();
		txtDtNasc.setBounds(221, 96, 65, 20);
		painelDados.add(txtDtNasc);
		txtDtNasc.setColumns(10);
		
		JRadioButton btnRadioHomem = new JRadioButton("Homem");
		btnRadioHomem.setBackground(new Color(255, 255, 225));
		btnRadioHomem.setBounds(49, 123, 76, 23);
		btnRadioHomem.setActionCommand("M");
		painelDados.add(btnRadioHomem);
		
		JRadioButton btnRadioMulher = new JRadioButton("Mulher");
		btnRadioMulher.setBackground(new Color(255, 255, 225));
		btnRadioMulher.setBounds(127, 123, 65, 23);
		btnRadioMulher.setActionCommand("F");
		painelDados.add(btnRadioMulher);
		
		btnGrupoSexo = new ButtonGroup();
		btnGrupoSexo.add(btnRadioHomem);
		btnGrupoSexo.add(btnRadioMulher);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(10, 171, 34, 20);
		painelDados.add(txtAltura);
		txtAltura.setColumns(10);
		
		txtPeso = new JTextField();
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
		cbAtividade.setModel(new DefaultComboBoxModel(new String[] {"Sedent\u00E1rio ", "Levemente Ativo", "Moderadamente Ativo", "Bastante Ativo", "Muito Ativo"}));
		cbAtividade.setBounds(151, 171, 149, 20);
		painelDados.add(cbAtividade);
		
		JButton btnDinamico = new JButton("");
		btnDinamico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente cliente = new Cliente();
				cliente.setCpf(txtCpf.getText());
				cliente.setNome(txtNome.getText());
				cliente.setEmail(txtEmail.getText());
				cliente.setSexo(btnGrupoSexo.getSelection().getActionCommand());
				cliente.setDtNasc(txtDtNasc.getText());
				cliente.setAltura(Integer.parseInt(txtAltura.getText()));
				cliente.setPeso(Integer.parseInt(txtPeso.getText()));
				cliente.setAtividade(cbAtividade.getSelectedItem().toString());
				
				ClienteDAO clienteDAO = new ClienteDAO();
				clienteDAO.setCliente(cliente);
				
				if(lblOperacao.getText().equals("NOVO")){
					clienteDAO.gravar();
					limpar();
				}
			}
		});
		btnDinamico.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/senai/jandira/sp/images/salvar.png")));
		btnDinamico.setBackground(new Color(255, 255, 255));
		btnDinamico.setBounds(10, 213, 58, 52);
		painelDados.add(btnDinamico);
		
		JButton btnSair = new JButton("");
		btnSair.setBackground(new Color(255, 255, 255));
		btnSair.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/senai/jandira/sp/images/sair.png")));
		btnSair.setBounds(242, 213, 58, 52);
		painelDados.add(btnSair);
		
		JPanel painelResultados = new JPanel();
		painelResultados.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Resultados:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(37, 183, 211)));
		painelResultados.setBackground(new Color(255, 255, 225));
		painelResultados.setBounds(330, 75, 404, 276);
		painelPrincipal.add(painelResultados);
		painelResultados.setLayout(null);
		
		JLabel lblNome_1 = new JLabel("Nome:");
		lblNome_1.setBounds(69, 23, 45, 14);
		painelResultados.add(lblNome_1);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(69, 48, 45, 14);
		painelResultados.add(lblIdade);
		
		JLabel lblAltura_1 = new JLabel("Altura:");
		lblAltura_1.setBounds(67, 73, 47, 14);
		painelResultados.add(lblAltura_1);
		
		JLabel lblPeso_1 = new JLabel("Peso:");
		lblPeso_1.setBounds(73, 98, 41, 14);
		painelResultados.add(lblPeso_1);
		
		JLabel lblImc = new JLabel("IMC:");
		lblImc.setBounds(77, 148, 37, 14);
		painelResultados.add(lblImc);
		
		JLabel lblAtividade_1 = new JLabel("N\u00EDvel de Atividade:");
		lblAtividade_1.setBounds(10, 123, 104, 14);
		painelResultados.add(lblAtividade_1);
		
		JLabel lblTmb = new JLabel("TMB:");
		lblTmb.setBounds(76, 226, 38, 14);
		painelResultados.add(lblTmb);
		
		JLabel lblFcm = new JLabel("FCM:");
		lblFcm.setBounds(75, 251, 39, 14);
		painelResultados.add(lblFcm);
		
		JLabel lblRespostaNome = new JLabel("-");
		lblRespostaNome.setBounds(124, 23, 270, 14);
		painelResultados.add(lblRespostaNome);
		
		JLabel lblRespostaIdade = new JLabel("-");
		lblRespostaIdade.setBounds(124, 48, 271, 14);
		painelResultados.add(lblRespostaIdade);
		
		JLabel lblRespostaAltura = new JLabel("-");
		lblRespostaAltura.setBounds(124, 73, 270, 14);
		painelResultados.add(lblRespostaAltura);
		
		JLabel lblRespostaPeso = new JLabel("-");
		lblRespostaPeso.setBounds(124, 98, 270, 14);
		painelResultados.add(lblRespostaPeso);
		
		JLabel lblRespostaAtividade = new JLabel("-");
		lblRespostaAtividade.setBounds(124, 123, 270, 14);
		painelResultados.add(lblRespostaAtividade);
		
		JLabel lblRespostaImc = new JLabel("-");
		lblRespostaImc.setBounds(124, 148, 270, 14);
		painelResultados.add(lblRespostaImc);
		
		JLabel lblRespostaTmb = new JLabel("-");
		lblRespostaTmb.setBounds(124, 226, 270, 14);
		painelResultados.add(lblRespostaTmb);
		
		JLabel lblRespostaFcm = new JLabel("-");
		lblRespostaFcm.setBounds(124, 251, 270, 14);
		painelResultados.add(lblRespostaFcm);
		
		JTextArea txtImc = new JTextArea();
		txtImc.setEditable(false);
		txtImc.setBounds(110, 173, 284, 42);
		painelResultados.add(txtImc);
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
		txtNome.requestFocus();
	}
}
