package br.senai.jandira.sp.model;

public class Cliente {
	
	// Atributos de 'Cliente'
	private String cpf;
	private String nome;
	private String email;
	private String sexo;
	private String dtNasc;
	private String atividade;
	private String respostaImc;
	private int idade;
	private double altura;
	private double peso;
	private double imc;
	private double tmb;
	private double fcm;
	
	// M�todos getters e setters de 'Cliente'
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public double getTmb() {
		return tmb;
	}

	public void setTmb(double tmb) {
		this.tmb = tmb;
	}

	public double getFcm() {
		return fcm;
	}

	public void setFcm(double fcm) {
		this.fcm = fcm;
	}

	public String getRespostaImc() {
		return respostaImc;
	}

	public void setRespostaImc(String respostaImc) {
		this.respostaImc = respostaImc;
	}
	
	// M�todos dos calculos do 'IMC', 'TMB' e 'FCM'
	public double imc() {

		imc = peso / (altura / 100 * altura / 100);

		if (imc <= 16.9) {
			respostaImc = "<html><body>Muito abaixo do peso:<br>Queda de cabelo, infertilidade, aus�ncia menstrual.";
		} else if (imc <= 18.4) {
			respostaImc = "<html><body>Abaixo do peso:<br>Fadiga, stress, ansiedade.";
		} else if (imc <= 24.9) {
			respostaImc = "<html><body>Peso normal:<br>Menor risco de doen�as card�acas e vasculares.";
		} else if (imc <= 29.9) {
			respostaImc = "<html><body>Acima do peso:<br>Fadiga, m� circula��o, varizes.";
		} else if (imc <= 34.9) {
			respostaImc = "<html><body>Obesidade Grau I:<br>Diabetes, angina, infarto, aterosclerose.";
		} else if (imc <= 40) {
			respostaImc = "<html><body>Obesidade Grau II:<br>Apneia do sono, falta de ar.";
		} else if (imc > 40) {
			respostaImc = "<html><body>Obesidade Grau III:<br>Refluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC.";
		}

		return imc;
	}

	public double tmb() {
		if (sexo == "M") {
			tmb = 66 + (13.7 * peso) + (5 * altura) - (6.8 * idade);
		} else if (sexo == "F") {
			tmb = 665 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade);
		}

		if (atividade == "Sedent�rio") {
			tmb = tmb * 1.20;
		} else if (atividade == "Levemente Ativo") {
			tmb = tmb * 1.37;
		} else if (atividade == "Moderadamente Ativo") {
			tmb = tmb * 1.55;
		} else if (atividade == "Bastante Ativo") {
			tmb = tmb * 1.72;
		} else if (atividade == "Muito Ativo") {
			tmb = tmb * 1.90;
		}

		return tmb;
	}

	public double fcm() {
		if (sexo == "M") {
			fcm = ((210 - (0.5 * idade)) - peso * 1 / 100) + 4;
		} else if (sexo == "F") {
			fcm = ((210 - (0.5 * idade)) - peso * 1 / 100);
		}
		return fcm;
	}
}
