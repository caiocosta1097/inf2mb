package br.senai.jandira.sp.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class FrmClientes extends JFrame {

	private JPanel painelTabela;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtDtNasc;
	private JTextField txtAltura;
	private JTextField txtPeso;

	public FrmClientes() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 375);
		painelTabela = new JPanel();
		painelTabela.setBackground(new Color(255, 255, 225));
		painelTabela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelTabela);
		painelTabela.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelTitulo.setBackground(new Color(255, 255, 255));
		painelTitulo.setBounds(0, 0, 744, 64);
		painelTabela.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Boa Forma");
		lblNewLabel.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/senai/jandira/sp/images/academia.png")));
		lblNewLabel.setForeground(new Color(37, 183, 211));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 32));
		lblNewLabel.setBounds(10, 0, 420, 64);
		painelTitulo.add(lblNewLabel);
		
		JPanel painelDados = new JPanel();
		painelDados.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Dados:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(37, 183, 211)));
		painelDados.setBackground(new Color(255, 255, 225));
		painelDados.setBounds(10, 75, 310, 260);
		painelTabela.add(painelDados);
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
		txtDtNasc.setBounds(211, 96, 65, 20);
		painelDados.add(txtDtNasc);
		txtDtNasc.setColumns(10);
		
		JRadioButton btnRadioHomem = new JRadioButton("Homem");
		btnRadioHomem.setBackground(new Color(255, 255, 225));
		btnRadioHomem.setBounds(49, 123, 65, 23);
		painelDados.add(btnRadioHomem);
		
		JRadioButton btnRadioMulher = new JRadioButton("Mulher");
		btnRadioMulher.setBackground(new Color(255, 255, 225));
		btnRadioMulher.setBounds(125, 123, 65, 23);
		painelDados.add(btnRadioMulher);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(10, 171, 34, 20);
		painelDados.add(txtAltura);
		txtAltura.setColumns(10);
		
		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(68, 171, 46, 20);
		painelDados.add(txtPeso);
		
		JLabel lblCm = new JLabel("cm");
		lblCm.setBounds(49, 174, 18, 14);
		painelDados.add(lblCm);
		
		JLabel lblQuilos = new JLabel("quilos");
		lblQuilos.setBounds(118, 174, 34, 14);
		painelDados.add(lblQuilos);
		
		JLabel lblAtividade = new JLabel("N\u00EDvel de Atividade:");
		lblAtividade.setBounds(151, 152, 99, 14);
		painelDados.add(lblAtividade);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sedent\u00E1rio ", "Levemente Ativo", "Moderadamente Ativo", "Bastante Ativo", "Muito Ativo"}));
		comboBox.setBounds(151, 171, 149, 20);
		painelDados.add(comboBox);
		
		JButton btnDinamico = new JButton("");
		btnDinamico.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/senai/jandira/sp/images/salvar.png")));
		btnDinamico.setBackground(new Color(255, 255, 255));
		btnDinamico.setBounds(10, 202, 58, 52);
		painelDados.add(btnDinamico);
		
		JButton btnSair = new JButton("");
		btnSair.setBackground(new Color(255, 255, 255));
		btnSair.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/senai/jandira/sp/images/sair.png")));
		btnSair.setBounds(242, 202, 58, 52);
		painelDados.add(btnSair);
		
		JPanel painelResultados = new JPanel();
		painelResultados.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Resultados:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(37, 183, 211)));
		painelResultados.setBackground(new Color(255, 255, 225));
		painelResultados.setBounds(330, 75, 404, 260);
		painelTabela.add(painelResultados);
		painelResultados.setLayout(null);
	}
}
