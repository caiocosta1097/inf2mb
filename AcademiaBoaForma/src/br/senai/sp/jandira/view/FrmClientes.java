package br.senai.sp.jandira.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import br.senai.sp.jandira.model.Cliente;
import br.senai.sp.jandira.view.FrmClientes;
import javax.swing.Icon;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;

public class FrmClientes extends JFrame {
	// IMAGEM ICON

	// JPANEL
	JPanel plnTitulo = new JPanel();
	JPanel plnDados = new JPanel();
	JPanel plnResultados = new JPanel();
	JLabel lblTitulo = new JLabel(" Boa Forma");
	JLabel lblNome = new JLabel("Nome:");
	JLabel lblSexo = new JLabel("Sexo:");
	JLabel lblPeso = new JLabel("Peso:");
	JLabel lblAltura = new JLabel("Altura:");
	JLabel lblIdade = new JLabel("Idade:");
	JLabel lblQuilos = new JLabel("quilos");
	JLabel lblCm = new JLabel("cm");
	JLabel lblAnos = new JLabel("anos");
	JLabel lblAtividade = new JLabel("Nível de Atividade:");
	JLabel lblNome2 = new JLabel("Nome:");
	JLabel lblPeso2 = new JLabel("Peso:");
	JLabel lblAltura2 = new JLabel("Altura:");
	JLabel lblIdade2 = new JLabel("Idade:");
	JLabel lblAtividade2 = new JLabel("Nível de Atividade:");
	JLabel lblImc = new JLabel("IMC:");
	JLabel lblTmb = new JLabel("TMB:");
	JLabel lblFcm = new JLabel("FCM:");
	JLabel lblRespostaImc = new JLabel();
	JLabel lblResultadoNome = new JLabel("-");
	JLabel lblResultadoIdade = new JLabel("-");
	JLabel lblResultadoAltura = new JLabel("-");
	JLabel lblResultadoPeso = new JLabel("-");
	JLabel lblResultadoAtividade = new JLabel("-");
	JLabel lblResultadoImc = new JLabel("-");
	JLabel lblResultadoTmb = new JLabel("-");
	JLabel lblResultadoFcm = new JLabel("-");

	// COLOR
	Color fundo = new Color(255, 255, 225);
	Color azul = new Color(66, 149, 206);
	Color branco = new Color(255, 255, 255);
	Color verde = new Color(61, 173, 125);
	// FONT
	Font titulo = new Font("Arial", 1, 40);
	Font arial = new Font("Arial", 0, 12);

	// TEXT FIELD
	TextField txtNome = new TextField();
	TextField txtPeso = new TextField();
	TextField txtAltura = new TextField();
	TextField txtIdade = new TextField();

	// JRADIO
	JRadioButton btnRadioHomem = new JRadioButton("Homem");
	JRadioButton btnRadioMulher = new JRadioButton("Mulher");
	ButtonGroup btnGrupoSexo = new ButtonGroup();

	// JBUTTON
	JButton btnSalvar = new JButton("");
	Insets margens = new Insets(1, 1, 1, 1);

	// DECIMAL FORMAT
	DecimalFormat decimal = new DecimalFormat("0.#");

	// BORDER E TITLE BORDER
	Border bordaDados = BorderFactory.createLineBorder(Color.lightGray);
	TitledBorder tituloDados = BorderFactory.createTitledBorder(bordaDados, "Dados:");
	Border bordaResultados = BorderFactory.createLineBorder(Color.lightGray);
	TitledBorder tituloResultados = BorderFactory.createTitledBorder(bordaDados, "Resultados:");
	// CLASSE CALCULO BOA FORMA
	Cliente cliente = new Cliente();

	// CONSTRUTOR
	public FrmClientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmClientes.class.getResource("/br/senai/sp/jandira/images/academia.png")));
		// JANELA
		setSize(790, 480);
		setTitle("Academia Boa Forma");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		this.getContentPane().setBackground(fundo);
		plnTitulo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(plnTitulo);
		getContentPane().add(plnDados);
		getContentPane().add(plnResultados);

		// COMBO BOX
		JComboBox<String> cbAtividade = new JComboBox<>();
		String[] atividade = { "Sedentário", "Levemente Ativo", "Moderadamente Ativo", "Bastante Ativo",
				"Muito Ativo" };
		DefaultComboBoxModel<String> modelComboAtividade = new DefaultComboBoxModel<>(atividade);

		// PAINEL PRINCIPAL
		plnTitulo.setBounds(0, 0, 800, 75);
		plnTitulo.setLayout(null);
		plnTitulo.setBackground(Color.WHITE);
		lblTitulo.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/senai/sp/jandira/images/academia.png")));
		plnTitulo.add(lblTitulo);

		lblTitulo.setBounds(10, 5, 382, 64);
		lblTitulo.setFont(titulo);
		lblTitulo.setForeground(azul);

		// PAINEL ESQUERDA
		plnDados.setBounds(10, 90, 345, 350);
		plnDados.setLayout(null);
		plnDados.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Dados:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tituloDados.setTitleColor(azul);
		plnDados.setBackground(fundo);

		plnDados.add(lblNome);
		plnDados.add(lblSexo);
		plnDados.add(lblPeso);
		plnDados.add(lblAltura);
		plnDados.add(lblIdade);
		plnDados.add(txtNome);
		plnDados.add(txtPeso);
		plnDados.add(txtAltura);
		plnDados.add(txtIdade);
		plnDados.add(lblQuilos);
		plnDados.add(lblCm);
		plnDados.add(lblAnos);
		plnDados.add(btnRadioHomem);
		plnDados.add(btnRadioMulher);
		plnDados.add(lblAtividade);
		plnDados.add(cbAtividade);
		btnSalvar.setBackground(new Color(255, 255, 255));
		btnSalvar.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/senai/sp/jandira/images/salvar.png")));
		plnDados.add(btnSalvar);

		lblNome.setBounds(10, 25, 45, 20);
		txtNome.setBounds(55, 25, 280, 23);

		lblSexo.setBounds(10, 55, 45, 20);
		btnRadioHomem.setBounds(55, 55, 80, 20);
		btnGrupoSexo.add(btnRadioHomem);
		btnRadioHomem.setActionCommand("Homem");
		btnRadioHomem.setBackground(fundo);
		btnRadioMulher.setBounds(140, 55, 80, 20);
		btnGrupoSexo.add(btnRadioMulher);
		btnRadioMulher.setActionCommand("Mulher");
		btnRadioMulher.setBackground(fundo);

		lblPeso.setBounds(10, 85, 45, 20);
		txtPeso.setBounds(55, 85, 60, 23);
		lblQuilos.setBounds(120, 85, 45, 20);
		lblQuilos.setFont(arial);

		lblAltura.setBounds(10, 115, 45, 20);
		txtAltura.setBounds(55, 115, 60, 23);
		lblCm.setBounds(120, 115, 45, 20);
		lblCm.setFont(arial);

		lblIdade.setBounds(10, 145, 45, 20);
		txtIdade.setBounds(55, 145, 60, 23);
		lblAnos.setBounds(120, 145, 45, 20);
		lblAnos.setFont(arial);

		lblAtividade.setBounds(10, 195, 110, 20);
		cbAtividade.setModel(modelComboAtividade);
		cbAtividade.setBounds(10, 220, 325, 25);

		btnSalvar.setBounds(20, 266, 80, 50);
		btnSalvar.setMargin(margens);

		// PAINEL DIREITA
		plnResultados.setBounds(365, 90, 410, 350);
		plnResultados.setLayout(null);
		plnResultados.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Resultados:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tituloResultados.setTitleColor(azul);
		plnResultados.setBackground(fundo);

		plnResultados.add(lblNome2);
		plnResultados.add(lblIdade2);
		plnResultados.add(lblAltura2);
		plnResultados.add(lblPeso2);
		plnResultados.add(lblAtividade2);
		plnResultados.add(lblImc);
		plnResultados.add(lblTmb);
		plnResultados.add(lblFcm);
		plnResultados.add(lblRespostaImc);
		plnResultados.add(lblResultadoNome);
		plnResultados.add(lblResultadoIdade);
		plnResultados.add(lblResultadoAltura);
		plnResultados.add(lblResultadoPeso);
		plnResultados.add(lblResultadoAtividade);
		plnResultados.add(lblResultadoImc);
		plnResultados.add(lblResultadoTmb);
		plnResultados.add(lblResultadoFcm);

		lblNome2.setBounds(79, 25, 45, 20);
		lblResultadoNome.setBounds(125, 25, 275, 20);

		lblIdade2.setBounds(81, 55, 45, 20);
		lblResultadoIdade.setBounds(125, 55, 275, 20);

		lblAltura2.setBounds(77, 85, 45, 20);
		lblResultadoAltura.setBounds(125, 85, 275, 20);

		lblPeso2.setBounds(80, 115, 45, 20);
		lblResultadoPeso.setBounds(125, 115, 275, 20);

		lblAtividade2.setBounds(10, 145, 110, 20);
		lblResultadoAtividade.setBounds(125, 145, 275, 20);

		lblImc.setBounds(86, 175, 45, 20);
		lblResultadoImc.setBounds(125, 175, 275, 20);
		lblRespostaImc.setBounds(125, 205, 275, 60);
		lblRespostaImc.setOpaque(true);
		lblRespostaImc.setBackground(branco);

		lblTmb.setBounds(85, 270, 45, 20);
		lblResultadoTmb.setBounds(125, 270, 275, 20);

		lblFcm.setBounds(85, 300, 45, 20);
		lblResultadoFcm.setBounds(125, 300, 275, 20);

		// AÇOES DO BOTÃO
		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// INSERIR VALOR DOS ATRIBUTOS
				cliente.setNome(txtNome.getText());
				cliente.setSexo(btnGrupoSexo.getSelection().getActionCommand());
				cliente.setAtividade(cbAtividade.getSelectedItem().toString());
				cliente.setPeso(Double.parseDouble(txtPeso.getText()));
				cliente.setAltura(Double.parseDouble(txtAltura.getText()));
				cliente.setIdade(Integer.parseInt(txtIdade.getText()));
				cliente.setIntPeso((int) cliente.getPeso());
				cliente.setIntAltura((int) cliente.getAltura());
				cliente.setIntTmb((int) cliente.tmb());
				cliente.setIntFcm((int) cliente.fcm());

				// INSERIR ATRIBUTOS NA TELA
				lblResultadoNome.setForeground(verde);
				lblResultadoNome.setText(cliente.getNome());

				lblResultadoPeso.setForeground(verde);
				lblResultadoPeso.setText(String.valueOf(cliente.getIntPeso() + " quilos"));

				lblResultadoAltura.setForeground(verde);
				lblResultadoAltura.setText(String.valueOf(cliente.getIntAltura() + " cm"));

				lblResultadoIdade.setForeground(verde);
				lblResultadoIdade.setText(String.valueOf(cliente.getIdade() + " anos"));

				lblResultadoAtividade.setForeground(verde);
				lblResultadoAtividade.setText(cbAtividade.getSelectedItem().toString());

				lblResultadoImc.setForeground(verde);
				lblResultadoImc.setText(String.valueOf(decimal.format(cliente.imc()) + " kg/m²"));
				lblRespostaImc.setText(cliente.getRespostaImc());

				lblResultadoTmb.setForeground(verde);
				lblResultadoTmb.setText(String.valueOf(cliente.getIntTmb()));

				lblResultadoFcm.setForeground(verde);
				lblResultadoFcm.setText(String.valueOf(cliente.getIntFcm()));

			}
		});

		setVisible(true);
	}
}
